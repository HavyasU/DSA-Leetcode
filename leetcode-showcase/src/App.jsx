import React, { useEffect, useState } from "react";
import Sidebar from "./components/Sidebar";
import ProblemView from "./components/ProblemView";
import { fetchStructure } from "./github";

export default function App() {
  const [problems, setProblems] = useState([]);
  const [loading, setLoading] = useState(false);
  const [selected, setSelected] = useState(null);
  const [search, setSearch] = useState("");

  const OWNER = "HavyasU";
  const REPO = "DSA-Leetcode";

  useEffect(() => {
    setLoading(true);
    fetchStructure(OWNER, REPO)
      .then((data) => {
        setProblems(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Failed to load repo structure", err);
        setLoading(false);
      });
  }, []);

  return (
    <div className="flex h-screen w-screen overflow-hidden bg-dark-bg text-dark-text font-sans selection:bg-brand-blue/30 selection:text-white">
      <Sidebar
        problems={problems}
        selected={selected}
        onSelect={setSelected}
        search={search}
        setSearch={setSearch}
        loading={loading}
      />

      <ProblemView problem={selected} owner={OWNER} repo={REPO} />
    </div>
  );
}
