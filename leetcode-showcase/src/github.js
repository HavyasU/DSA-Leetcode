const RAW_BASE = (owner, repo, branch = 'main') => `https://raw.githubusercontent.com/${owner}/${repo}/${branch}`;
const API_TREE = (owner, repo, branch = 'main') => `https://api.github.com/repos/${owner}/${repo}/git/trees/${branch}?recursive=1`;

export async function fetchStructure(owner, repo, branch = 'main') {
    try {
        const response = await fetch(API_TREE(owner, repo, branch));
        if (!response.ok) throw new Error('Failed to fetch repo structure');
        const data = await response.json();

        // Filter for directories that look like problems (e.g., "001-TwoSum")
        // We confirm it's a problem if it has a Solution.java
        const allPaths = data.tree || [];
        const problemsMap = new Map();

        for (const item of allPaths) {
            if (item.path.endsWith('Solution.java')) {
                const parts = item.path.split('/');
                // standard structure: 001-TwoSum/Solution.java
                if (parts.length >= 2) {
                    const folder = parts[0];
                    // Check if folder starts with digits
                    if (/^\d+-/.test(folder)) {
                        problemsMap.set(folder, {
                            folder,
                        });
                    }
                }
            }
        }

        const problems = Array.from(problemsMap.values()).map(p => {
            const parts = p.folder.split('-');
            const id = parts[0];
            const rawTitle = parts.slice(1).join(''); // Rejoin strictly 
            // Convert CamelCase to Spaced
            const title = rawTitle.replace(/([a-z])([A-Z])/g, '$1 $2');

            return {
                id,
                title,
                folder: p.folder,
            };
        });

        // Sort by ID
        return problems.sort((a, b) => parseInt(a.id) - parseInt(b.id));

    } catch (error) {
        console.error("Error fetching structure:", error);
        return [];
    }
}

export async function fetchFileContent(owner, repo, path, branch = 'main') {
    const url = `${RAW_BASE(owner, repo, branch)}/${path}`;
    try {
        const res = await fetch(url);
        if (!res.ok) return null;
        return await res.text();
    } catch (e) {
        console.error("Fetch error", e);
        return null;
    }
}

export async function fetchProblemDetails(owner, repo, folder, branch = 'main') {
    const readmeVariants = ['README.md', 'readme.md', 'Readme.md'];
    let readme = null;

    // Fetch readme and code in parallel for speed
    const readmePromises = readmeVariants.map(name => fetchFileContent(owner, repo, `${folder}/${name}`, branch));
    const codePromise = fetchFileContent(owner, repo, `${folder}/Solution.java`, branch);

    const [code, ...readmes] = await Promise.all([codePromise, ...readmePromises]);

    readme = readmes.find(r => r !== null) || "No README found.";

    return { readme, code: code || "// Solution.java not found" };
}
