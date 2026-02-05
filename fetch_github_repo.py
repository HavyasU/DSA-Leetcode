"""Fetch Solution.java and README files from a public GitHub repo and write data/problems.json
Usage: python fetch_github_repo.py owner repo branch
Example: python fetch_github_repo.py HavyasU DSA-Leetcode main
"""
import sys
import json
import urllib.request
import urllib.error

if len(sys.argv) < 4:
    print("Usage: python fetch_github_repo.py owner repo branch")
    sys.exit(2)
owner, repo, branch = sys.argv[1:4]

api_tree = f"https://api.github.com/repos/{owner}/{repo}/git/trees/{branch}?recursive=1"
print("Fetching repo tree...", api_tree)
try:
    with urllib.request.urlopen(api_tree) as r:
        tree = json.load(r).get('tree', [])
except urllib.error.HTTPError as e:
    print('HTTP error:', e)
    sys.exit(1)

solutions = [item['path'] for item in tree if item['path'].endswith('Solution.java')]
print(f'Found {len(solutions)} solution files')

problems = []
for path in solutions:
    parts = path.split('/')
    folder = parts[0] if len(parts)>1 else ''
    # try readme variations
    readme_candidates = [f"{folder}/README.md", f"{folder}/readme.md", f"{folder}/Readme.md"]
    readme_content = ''
    for r in readme_candidates:
        raw_url_r = f"https://raw.githubusercontent.com/{owner}/{repo}/{branch}/{r}"
        try:
            with urllib.request.urlopen(raw_url_r) as rr:
                readme_content = rr.read().decode('utf-8')
                break
        except Exception:
            readme_content = ''
    raw_url = f"https://raw.githubusercontent.com/{owner}/{repo}/{branch}/{path}"
    try:
        with urllib.request.urlopen(raw_url) as f:
            code = f.read().decode('utf-8')
    except Exception as e:
        print('Failed to fetch', raw_url, e)
        code = ''
    # extract id and title from folder name
    if '-' in folder:
        id_part, title_part = folder.split('-', 1)
    else:
        id_part = folder
        title_part = folder
    problems.append({
        'id': id_part,
        'title': title_part.replace('-', ' '),
        'path': folder,
        'code': code,
        'readme': readme_content,
        'tags': [],
        'difficulty': None,
        'solved': False
    })

# write data
import os
os.makedirs('data', exist_ok=True)
with open('data/problems.json','w',encoding='utf-8') as out:
    json.dump(problems, out, ensure_ascii=False, indent=2)
print('Wrote data/problems.json with', len(problems), 'entries')
