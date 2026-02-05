import os
import json
import time
import urllib.request
import urllib.error
import ssl

# Instructions:
# 1. Login to LeetCode in your browser.
# 2. Open Developer Tools (F12) -> Network tab.
# 3. Refresh the page or click on a problem.
# 4. Find a GraphQL request (or any request to leetcode.com).
# 5. Copy the value of the 'Cookie' header.
# 6. Run this script: python fetch_leetcode_direct.py
# 7. Paste the cookie when prompted.

GRAPHQL_URL = "https://leetcode.com/graphql"
PROBLEMS_URL = "https://leetcode.com/api/problems/all/"

# Create a context to ignore SSL errors if any
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

def get_headers(cookie):
    csrf = ""
    if "csrftoken=" in cookie:
        try:
            csrf = cookie.split("csrftoken=")[1].split(";")[0]
        except:
            pass
            
    return {
        "Content-Type": "application/json",
        "Cookie": cookie,
        "x-csrftoken": csrf,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36",
        "Referer": "https://leetcode.com/problems/all/",
        "Origin": "https://leetcode.com"
    }

def make_request(url, method="GET", data=None, cookie=""):
    headers = get_headers(cookie)
    if data:
        data = json.dumps(data).encode("utf-8")
        
    req = urllib.request.Request(url, data=data, headers=headers, method=method)
    try:
        with urllib.request.urlopen(req, context=ctx) as r:
            return json.load(r)
    except urllib.error.HTTPError as e:
        print(f"Request failed to {url}: {e}")
        try:
            print(e.read().decode())
        except:
            pass
        return None
    except Exception as e:
        print(f"Error: {e}")
        return None

def fetch_all_solved_problems(cookie):
    print("Fetching list of ALL problems (this might take a moment)...")
    data = make_request(PROBLEMS_URL, method="GET", cookie=cookie)
    
    if not data:
        print("Failed to fetch problem list.")
        return []
        
    solved = []
    pairs = data.get("stat_status_pairs", [])
    print(f"Total problems found: {len(pairs)}")
    
    for p in pairs:
        if p.get("status") == "ac":
            stat = p.get("stat", {})
            solved.append({
                "id": stat.get("question_id"),
                "frontend_id": stat.get("frontend_question_id"),
                "title": stat.get("question__title"),
                "slug": stat.get("question__title_slug"),
            })
            
    print(f"Found {len(solved)} SOLVED problems.")
    return solved

def fetch_latest_submission_id(slug, cookie):
    # Query to get the latest submission for a specific question
    query = """
    query submissionList($questionSlug: String!, $offset: Int!, $limit: Int!) {
      submissionList(questionSlug: $questionSlug, offset: $offset, limit: $limit) {
        id
        statusDisplay
        lang
        timestamp
      }
    }
    """
    variables = {"questionSlug": slug, "offset": 0, "limit": 20}
    
    data = make_request(GRAPHQL_URL, method="POST", data={"query": query, "variables": variables}, cookie=cookie)
    
    if data and "data" in data and "submissionList" in data["data"]:
        subs = data["data"]["submissionList"]
        # Find the first 'Accepted' one
        for sub in subs:
            if sub["statusDisplay"] == "Accepted":
                return sub["id"]
    return None

def fetch_code_for_submission(submission_id, cookie):
    query = """
    query submissionDetails($submissionId: Int!) {
      submissionDetails(submissionId: $submissionId) {
        runtime
        code
        timestamp
        lang {
          name
        }
        question {
          questionId
          title
          titleSlug
          content
          difficulty
        }
      }
    }
    """
    variables = {"submissionId": int(submission_id)}
    data = make_request(GRAPHQL_URL, method="POST", data={"query": query, "variables": variables}, cookie=cookie)
    
    if data and "data" in data and "submissionDetails" in data["data"]:
        return data["data"]["submissionDetails"]
    return None

def main():
    print("--- LeetCode ALL Submissions Downloader ---")
    print("WARNING: This script requires your private 'LEETCODE_SESSION' cookie.")
    cookie = input("Enter your full Cookie string (from browser network tab): ").strip()
    
    if not cookie:
        print("Cookie is required.")
        return

    base_dir = os.path.join(os.getcwd(), "LeetCode_Direct_Fetch")
    os.makedirs(base_dir, exist_ok=True)
    
    # 1. Get all solved problems
    solved_problems = fetch_all_solved_problems(cookie)
    
    if not solved_problems:
        print("No solved problems found. Check your cookie or session.")
        return

    print(f"Prepare to download {len(solved_problems)} problems...")
    
    for i, problem in enumerate(solved_problems):
        slug = problem["slug"]
        fid = problem["frontend_id"]
        title = problem["title"]
        
        print(f"[{i+1}/{len(solved_problems)}] Processing {fid}: {title}...", end=" ")
        
        # Check if already downloaded to skip?
        # Construct expected folder name to check
        # We need to be careful about folder naming consistency with merge script
        # The merge script handles "ID-slug".
        # Let's just download everything to be safe, or check simple existence.
        
        # 2. Get latest submission ID
        sub_id = fetch_latest_submission_id(slug, cookie)
        if not sub_id:
            print("No accepted submission found.")
            continue
            
        # 3. Get code
        details = fetch_code_for_submission(sub_id, cookie)
        if not details:
            print("Failed to get code.")
            continue
            
        # Save
        code = details['code']
        q_id = details['question']['questionId'] # backend ID
        # We prefer frontend ID for folder name usually, or match existing
        # The 'details' object has question details too.
        
        # folder_name = f"{q_id}-{slug}" 
        # Using frontend ID is better for sorting: "001-two-sum"
        # API returns frontend_question_id in the problem list.
        # Let's use that.
        
        folder_name = f"{fid}-{slug}"
        folder_path = os.path.join(base_dir, folder_name)
        os.makedirs(folder_path, exist_ok=True)
        
        lang_data = details.get('lang', {})
        lang_name = lang_data.get('name', 'txt') if isinstance(lang_data, dict) else 'txt'
        
        ext = 'txt'
        if lang_name == 'java': ext = 'java'
        elif lang_name == 'python3': ext = 'py'
        elif lang_name == 'python': ext = 'py'
        elif lang_name == 'cpp': ext = 'cpp'
        elif lang_name == 'javascript': ext = 'js'
        
        with open(os.path.join(folder_path, f"Solution.{ext}"), "w", encoding='utf-8') as f:
            f.write(code)
            
        readme_content = f"# {title}\n\n{details['question']['content']}"
        with open(os.path.join(folder_path, "README.md"), "w", encoding='utf-8') as f:
            f.write(readme_content)
        
        print(f"Saved to {folder_name}")
        
        # Sleep to be nice to API
        time.sleep(1)

    print("Done! Check 'LeetCode_Direct_Fetch' folder.")

if __name__ == "__main__":
    main()
