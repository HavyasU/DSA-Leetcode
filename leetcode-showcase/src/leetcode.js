export async function fetchUserStats(username) {
    try {
        const res = await fetch(`https://leetcode-stats-api.herokuapp.com/${username}`);
        if (!res.ok) return null;
        return await res.json();
    } catch (error) {
        console.error("Failed to fetch user stats", error);
        return null;
    }
}

export async function fetchProblemContent(slug) {
    const query = `
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        content
        title
        difficulty
        mysqlSchemas
      }
    }
    `;

    try {
        const res = await fetch('/leetcode-api/graphql', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                query,
                variables: { titleSlug: slug }
            })
        });

        if (!res.ok) return null;
        const json = await res.json();
        return json.data?.question;
    } catch (error) {
        console.error("Failed to fetch problem content", error);
        return null;
    }
}

export function folderToSlug(folderName) {
    // 1480-ConcatenationofArray -> ["1480", "ConcatenationofArray"]
    const parts = folderName.split('-');
    if (parts.length < 2) return folderName.toLowerCase();

    // ConcatenationofArray -> concatenation-of-array is hard if casing is lost/bad
    // But usually it's PascalCase: AddTwoNumbers -> add-two-numbers

    const namePart = parts.slice(1).join('-');

    // separate camelCase/PascalCase
    // AddTwoNumbers -> Add Two Numbers
    const slug = namePart
        .replace(/([a-z0-9])([A-Z])/g, '$1-$2')
        .replace(/([A-Z])([A-Z][a-z])/g, '$1-$2')
        .toLowerCase();

    return slug;
}
