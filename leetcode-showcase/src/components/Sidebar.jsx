import React, { useEffect, useState } from "react";
import {
  Search,
  FolderGit2,
  Trophy,
  Sparkles,
  TrendingUp,
  Award,
  X,
} from "lucide-react";
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
  onClose,
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
    <motion.div
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      className="w-full h-screen flex flex-col border-r border-dark-border bg-dark-card/95 backdrop-blur-xl flex-shrink-0 z-20 shadow-2xl"
    >
      {/* Header */}
      <div className="p-5 pb-4 border-b border-dark-border/50 bg-gradient-to-b from-dark-card to-transparent">
        <div className="flex items-center justify-between mb-4">
          <motion.h1
            initial={{ y: -20, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            transition={{ delay: 0.1 }}
            className="text-2xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-brand-blue via-brand-purple to-brand-blue bg-[length:200%_auto] animate-gradient flex items-center gap-2"
          >
            <FolderGit2 className="text-brand-blue" size={28} />
            LeetCode Ref
          </motion.h1>

          {/* Close button for mobile */}
          {onClose && (
            <button
              onClick={onClose}
              className="lg:hidden p-2 hover:bg-white/10 rounded-lg transition-colors text-dark-muted hover:text-white"
              aria-label="Close menu"
            >
              <X size={24} />
            </button>
          )}
        </div>

        {/* Enhanced Stats Card */}
        <motion.div
          initial={{ scale: 0.95, opacity: 0 }}
          animate={{ scale: 1, opacity: 1 }}
          transition={{ delay: 0.2 }}
          className="mb-4 p-4 rounded-xl bg-gradient-to-br from-dark-bg/80 to-dark-bg/40 border border-dark-border/30 relative overflow-hidden group hover:border-brand-blue/30 transition-all duration-300"
        >
          <div className="absolute inset-0 bg-gradient-to-br from-brand-blue/5 to-brand-purple/5 opacity-0 group-hover:opacity-100 transition-opacity duration-300"></div>

          <div className="relative z-10">
            <div className="flex items-center justify-between mb-3">
              <div className="flex items-center gap-2">
                <div className="w-10 h-10 rounded-full bg-gradient-to-br from-brand-blue to-brand-purple flex items-center justify-center">
                  <Trophy size={20} className="text-white" />
                </div>
                <div>
                  <span className="text-xs font-mono text-dark-muted block">
                    @{USERNAME}
                  </span>
                  {stats && (
                    <span className="text-xs font-bold text-brand-purple flex items-center gap-1">
                      <Award size={12} />
                      Rank #{stats.ranking?.toLocaleString()}
                    </span>
                  )}
                </div>
              </div>
              <Sparkles size={16} className="text-brand-blue animate-pulse" />
            </div>

            <div className="grid grid-cols-3 gap-2">
              <StatCard
                label="Total"
                value={stats?.totalSolved || "-"}
                color="text-white"
              />
              <StatCard
                label="Easy"
                value={stats?.easySolved || "-"}
                color="text-green-400"
              />
              <StatCard
                label="Med"
                value={stats?.mediumSolved || "-"}
                color="text-yellow-400"
              />
            </div>
          </div>
        </motion.div>

        {/* Enhanced Search */}
        <motion.div
          initial={{ y: 20, opacity: 0 }}
          animate={{ y: 0, opacity: 1 }}
          transition={{ delay: 0.3 }}
          className="relative group"
        >
          <Search className="absolute left-3 top-2.5 h-4 w-4 text-dark-muted group-focus-within:text-brand-blue transition-colors" />
          <input
            type="text"
            placeholder="Search problems..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="w-full bg-dark-bg/50 border border-dark-border/50 rounded-lg pl-9 pr-4 py-2.5 text-sm text-dark-text focus:outline-none focus:ring-2 focus:ring-brand-blue/50 focus:border-brand-blue/50 transition-all placeholder:text-dark-muted hover:border-dark-border"
          />
        </motion.div>
      </div>

      {/* Problem List */}
      <div className="flex-1 overflow-y-auto px-2 py-3 space-y-1 custom-scrollbar">
        {loading ? (
          <div className="flex flex-col items-center justify-center p-8 text-dark-muted gap-3">
            <div className="relative">
              <div className="w-12 h-12 border-4 border-brand-blue/20 border-t-brand-blue rounded-full animate-spin"></div>
              <TrendingUp
                size={20}
                className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 text-brand-blue"
              />
            </div>
            <span className="text-xs font-medium">Syncing from GitHub...</span>
          </div>
        ) : filtered.length === 0 ? (
          <div className="p-8 text-center">
            <div className="text-4xl mb-2">🔍</div>
            <p className="text-dark-muted text-sm">No problems found</p>
          </div>
        ) : (
          filtered.map((p, idx) => (
            <motion.button
              key={p.id}
              initial={{ opacity: 0, x: -20 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ delay: idx * 0.02 }}
              onClick={() => onSelect(p)}
              className={clsx(
                "w-full text-left px-3 py-3 rounded-lg text-sm transition-all duration-200 group flex items-center gap-3 relative overflow-hidden",
                selected?.id === p.id
                  ? "text-white bg-gradient-to-r from-brand-blue/20 to-brand-purple/10 shadow-lg shadow-brand-blue/10"
                  : "text-dark-text/80 hover:bg-white/5 hover:text-white hover:shadow-md",
              )}
            >
              {selected?.id === p.id && (
                <motion.div
                  layoutId="active-indicator"
                  className="absolute left-0 top-0 w-1 h-full bg-gradient-to-b from-brand-blue to-brand-purple rounded-r"
                />
              )}
              <span
                className={clsx(
                  "font-mono text-[10px] min-w-[32px] text-center px-1.5 py-1 rounded-md border font-bold transition-all",
                  selected?.id === p.id
                    ? "bg-brand-blue/30 border-brand-blue/50 text-brand-blue shadow-sm shadow-brand-blue/20"
                    : "bg-dark-bg/50 border-dark-border/50 text-dark-muted group-hover:border-brand-blue/30 group-hover:text-brand-blue/70",
                )}
              >
                {p.id}
              </span>
              <span className="truncate flex-1 font-medium transition-all group-hover:translate-x-0.5">
                {p.title}
              </span>
              {selected?.id === p.id && (
                <motion.div
                  initial={{ scale: 0 }}
                  animate={{ scale: 1 }}
                  className="w-2 h-2 rounded-full bg-brand-blue animate-pulse"
                />
              )}
            </motion.button>
          ))
        )}
      </div>

      {/* Footer */}
      <div className="p-3 border-t border-dark-border/50 text-[10px] text-dark-muted flex justify-between items-center bg-dark-bg/30 backdrop-blur-sm">
        <span className="flex items-center gap-1">
          <span className="w-1.5 h-1.5 rounded-full bg-green-400 animate-pulse"></span>
          {problems.length} problems
        </span>
        <a
          href="https://github.com/HavyasU/DSA-Leetcode"
          target="_blank"
          className="hover:text-brand-blue transition-colors flex items-center gap-1 font-medium"
        >
          <span>GitHub</span>
          <svg className="w-3 h-3" fill="currentColor" viewBox="0 0 24 24">
            <path d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z" />
          </svg>
        </a>
      </div>
    </motion.div>
  );
}

function StatCard({ label, value, color }) {
  return (
    <div className="bg-dark-card/60 p-2 rounded-lg border border-dark-border/30 flex flex-col items-center hover:border-dark-border/60 transition-all group">
      <span className="text-[9px] text-dark-muted uppercase tracking-wide mb-0.5">
        {label}
      </span>
      <motion.span
        initial={{ scale: 0 }}
        animate={{ scale: 1 }}
        className={`font-bold text-base ${color} group-hover:scale-110 transition-transform`}
      >
        {value}
      </motion.span>
    </div>
  );
}
