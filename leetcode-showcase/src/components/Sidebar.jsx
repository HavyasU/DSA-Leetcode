import React, { useEffect, useState } from "react";
import { Search, FolderGit2, Trophy, Star, Target, Zap } from "lucide-react";
import clsx from "clsx";
import { fetchUserStats } from "../leetcode";
import { motion } from "framer-motion";

export default function Sidebar({
  problems,
  selected,
  onSelect,
  search,
  setSearch,
  loading,
}) {
  const [stats, setStats] = useState(null);

  const USERNAME = "havyasu2005";

  useEffect(() => {
    fetchUserStats(USERNAME).then(setStats);
  }, []);

  const filtered = problems.filter(
    (p) =>
      p.title.toLowerCase().includes(search.toLowerCase()) ||
      p.id.includes(search),
  );

  return (
    <div className="w-80 h-screen flex flex-col border-r border-dark-border bg-dark-card glass-panel flex-shrink-0 z-20 shadow-2xl">
      {/* Header */}
      <div className="p-5 pb-0">
        <h1 className="text-xl font-bold bg-clip-text text-transparent bg-brand-gradient flex items-center gap-2 mb-4">
          <FolderGit2 className="text-brand-blue" />
          LeetCode Ref
        </h1>

        {/* User Stats Card */}
        <div className="mb-4 p-3 rounded-lg bg-dark-bg/50 border border-dark-border relative overflow-hidden group">
          <div className="absolute top-0 right-0 p-2 opacity-10 group-hover:opacity-20 transition-opacity">
            <Trophy size={60} />
          </div>

          <div className="flex items-center justify-between mb-2">
            <span className="text-xs font-mono text-dark-muted">
              @{USERNAME}
            </span>
            {stats && (
              <span className="text-xs font-bold text-brand-purple">
                #{stats.ranking}
              </span>
            )}
          </div>

          <div className="flex gap-2 text-sm">
            <div className="flex-1 bg-dark-card/80 p-1.5 rounded border border-dark-border flex flex-col items-center">
              <span className="text-[10px] text-dark-muted uppercase">
                Solved
              </span>
              <span className="font-bold text-white">
                {stats ? stats.totalSolved : "-"}
              </span>
            </div>
            <div className="flex-1 bg-dark-card/80 p-1.5 rounded border border-dark-border flex flex-col items-center">
              <span className="text-[10px] text-dark-muted uppercase">
                Easy
              </span>
              <span className="font-bold text-green-400">
                {stats ? stats.easySolved : "-"}
              </span>
            </div>
            <div className="flex-1 bg-dark-card/80 p-1.5 rounded border border-dark-border flex flex-col items-center">
              <span className="text-[10px] text-dark-muted uppercase">Med</span>
              <span className="font-bold text-yellow-400">
                {stats ? stats.mediumSolved : "-"}
              </span>
            </div>
          </div>
        </div>

        <div className="relative mb-2">
          <Search className="absolute left-3 top-2.5 h-4 w-4 text-dark-muted" />
          <input
            type="text"
            placeholder="Search problems..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="w-full bg-dark-bg border border-dark-border rounded-lg pl-9 pr-4 py-2 text-sm text-dark-text focus:outline-none focus:ring-2 focus:ring-brand-blue/50 transition-all placeholder:text-dark-muted"
          />
        </div>
      </div>

      {/* List */}
      <div className="flex-1 overflow-y-auto px-2 py-2 space-y-0.5 custom-scrollbar">
        {loading ? (
          <div className="flex flex-col items-center justify-center p-8 text-dark-muted gap-2 opacity-50">
            <div className="w-5 h-5 border-2 border-brand-blue border-t-transparent rounded-full animate-spin"></div>
            <span className="text-xs">Syncing Github...</span>
          </div>
        ) : filtered.length === 0 ? (
          <div className="p-4 text-center text-dark-muted">
            No problems found
          </div>
        ) : (
          filtered.map((p) => (
            <button
              key={p.id}
              onClick={() => onSelect(p)}
              className={clsx(
                "w-full text-left px-3 py-2.5 rounded-md text-sm transition-all duration-200 group flex items-center gap-3 relative",
                selected?.id === p.id
                  ? "text-white bg-white/5"
                  : "text-dark-text/80 hover:bg-white/5 hover:text-white",
              )}
            >
              {selected?.id === p.id && (
                <motion.div
                  layoutId="active-pill"
                  className="absolute left-0 top-0 w-[3px] h-full bg-brand-blue rounded-r-sm"
                />
              )}
              <span
                className={clsx(
                  "font-mono text-[10px] min-w-[30px] text-center px-1 py-0.5 rounded border",
                  selected?.id === p.id
                    ? "bg-brand-blue/20 border-brand-blue/30 text-brand-blue"
                    : "bg-dark-bg border-dark-border text-dark-muted",
                )}
              >
                {p.id}
              </span>
              <span className="truncate flex-1 font-medium">{p.title}</span>
            </button>
          ))
        )}
      </div>

      <div className="p-3 border-t border-dark-border text-[10px] text-dark-muted text-center flex justify-between bg-dark-bg/30">
        <span>{problems.length} problems fetched</span>
        <a
          href="https://github.com/HavyasU/DSA-Leetcode"
          target="_blank"
          className="hover:text-brand-blue transition-colors flex items-center gap-1"
        >
          Sync Status: Live{" "}
          <Zap size={8} className="text-green-400 fill-green-400" />
        </a>
      </div>
    </div>
  );
}
