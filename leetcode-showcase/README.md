# LeetCode Showcase (client-side GitHub)

This is a minimal React + Vite app that fetches `Solution.java` and `README` files directly from a public GitHub repo (client-side) and shows a quick browser for revision.

Features:

- Fetches problems from GitHub repo tree on page load
- Search by id or title
- View README and solution code
- Mark solved/unsolved (stored in `localStorage`)

Quick start:

```bash
cd leetcode-showcase
npm install
npm run dev
```

Open `http://localhost:5173`.

Notes:

- This uses client-side requests to GitHub's APIs; it works for public repos. For private repos or higher reliability, add a serverless API (recommended).
- To enable near-real-time updates, add a GitHub webhook that triggers a redeploy or cache refresh.
