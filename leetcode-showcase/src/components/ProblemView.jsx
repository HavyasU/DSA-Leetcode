import React, { useState, useEffect } from "react";
import ReactMarkdown from "react-markdown";
import rehypeRaw from "rehype-raw";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { vscDarkPlus } from "react-syntax-highlighter/dist/esm/styles/prism";
import { fetchProblemDetails } from "../github";
import { fetchProblemContent, folderToSlug } from "../leetcode";
import {
  Code2,
  BookOpen,
  Loader2,
  CheckCircle2,
  Circle,
  Globe,
  Copy,
  ExternalLink,
  Check,
  Zap,
  Award,
} from "lucide-react";
import { motion, AnimatePresence } from "framer-motion";

export default function ProblemView({ problem, owner, repo }) {
  const [data, setData] = useState({ readme: "", code: "" });
  const [loading, setLoading] = useState(false);
  const [activeTab, setActiveTab] = useState("description");
  const [solved, setSolved] = useState(false);
  const [isFetchedFromLeetCode, setIsFetchedFromLeetCode] = useState(false);
  const [copied, setCopied] = useState(false);

  useEffect(() => {
    if (problem) {
      setLoading(true);
      setData({ readme: "", code: "" });
      setActiveTab("description");
      setIsFetchedFromLeetCode(false);
      setCopied(false);

      const loadData = async () => {
        try {
          const githubData = await fetchProblemDetails(
            owner,
            repo,
            problem.folder,
          );
          let readme = githubData.readme;
          let fetchedFromLC = false;

          if (
            !readme ||
            readme.length < 100 ||
            readme.includes("See `Solution.java`")
          ) {
            const slug = folderToSlug(problem.folder);
            try {
              const lcData = await fetchProblemContent(slug);
              if (lcData && lcData.content) {
                readme = lcData.content;
                fetchedFromLC = true;
              }
            } catch (e) {
              /* ignore */
            }
          }

          setData({
            readme: readme,
            code: githubData.code || "// No solution found locally.",
          });
          setIsFetchedFromLeetCode(fetchedFromLC);
        } catch (e) {
          console.error(e);
        } finally {
          setLoading(false);
        }
      };

      loadData();

      const solvedSet = new Set(
        JSON.parse(localStorage.getItem("solved") || "[]"),
      );
      setSolved(solvedSet.has(problem.id));
    }
  }, [problem, owner, repo]);

  const toggleSolved = () => {
    const solvedSet = new Set(
      JSON.parse(localStorage.getItem("solved") || "[]"),
    );
    if (solvedSet.has(problem.id)) {
      solvedSet.delete(problem.id);
      setSolved(false);
    } else {
      solvedSet.add(problem.id);
      setSolved(true);
    }
    localStorage.setItem("solved", JSON.stringify(Array.from(solvedSet)));
  };

  const copyCode = () => {
    navigator.clipboard.writeText(data.code);
    setCopied(true);
    setTimeout(() => setCopied(false), 2000);
  };

  const openLeetCode = () => {
    const slug = folderToSlug(problem.folder);
    window.open(`https://leetcode.com/problems/${slug}/`, "_blank");
  };

  if (!problem) {
    return (
      <div className="flex-1 flex flex-col items-center justify-center text-dark-muted select-none bg-gradient-to-br from-dark-bg via-dark-bg to-dark-card/30 backdrop-blur-sm min-h-screen px-4">
        <motion.div
          initial={{ scale: 0.8, opacity: 0, y: 20 }}
          animate={{ scale: 1, opacity: 1, y: 0 }}
          transition={{ duration: 0.6, type: "spring" }}
          className="text-center"
        >
          <div className="w-32 h-32 mx-auto mb-6 relative">
            <div className="absolute inset-0 bg-gradient-to-br from-brand-blue to-brand-purple rounded-full blur-2xl opacity-20 animate-pulse"></div>
            <div className="relative w-full h-full bg-dark-card rounded-full flex items-center justify-center border-2 border-dark-border shadow-2xl">
              <Code2 size={48} className="text-dark-muted" />
            </div>
          </div>
          <motion.h2
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ delay: 0.2 }}
            className="text-2xl font-bold text-white mb-2"
          >
            Select a Problem
          </motion.h2>
          <motion.p
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ delay: 0.3 }}
            className="text-dark-muted max-w-md"
          >
            Choose a problem from the sidebar to view its description and your
            solution
          </motion.p>
        </motion.div>
      </div>
    );
  }

  return (
    <div className="flex-1 flex flex-col h-screen overflow-hidden bg-gradient-to-br from-dark-bg via-dark-bg to-dark-card/20 relative">
      {/* Animated Background Elements */}
      <div className="absolute inset-0 overflow-hidden pointer-events-none">
        <motion.div
          animate={{
            scale: [1, 1.2, 1],
            opacity: [0.03, 0.08, 0.03],
          }}
          transition={{ duration: 8, repeat: Infinity }}
          className="absolute top-[-20%] right-[-10%] w-[600px] h-[600px] bg-brand-purple rounded-full blur-[120px]"
        />
        <motion.div
          animate={{
            scale: [1.2, 1, 1.2],
            opacity: [0.05, 0.1, 0.05],
          }}
          transition={{ duration: 10, repeat: Infinity }}
          className="absolute bottom-[-20%] left-[-10%] w-[600px] h-[600px] bg-brand-blue rounded-full blur-[120px]"
        />
      </div>

      {/* Header */}
      <motion.div
        initial={{ y: -20, opacity: 0 }}
        animate={{ y: 0, opacity: 1 }}
        className="border-b border-dark-border/50 p-4 pl-16 lg:pl-6 lg:p-6 flex flex-col md:flex-row md:justify-between md:items-start gap-4 bg-dark-card/80 backdrop-blur-xl sticky top-0 z-20 shadow-lg"
      >
        <div className="flex-1">
          <div className="flex items-center flex-wrap gap-2 md:gap-3 mb-2">
            <span className="font-mono text-xs font-bold px-2.5 py-1 rounded-lg bg-gradient-to-r from-brand-purple/20 to-brand-blue/20 border border-brand-purple/30 text-brand-purple shadow-sm">
              #{problem.id}
            </span>
            <h2 className="text-xl md:text-2xl font-bold text-white tracking-tight">
              {problem.title}
            </h2>
            <button
              onClick={openLeetCode}
              className="p-2 text-dark-muted hover:text-brand-blue transition-all rounded-lg hover:bg-brand-blue/10 group"
              title="Open in LeetCode"
            >
              <ExternalLink
                size={18}
                className="group-hover:scale-110 transition-transform"
              />
            </button>
          </div>
          <div className="flex flex-wrap gap-3 text-sm text-dark-muted items-center">
            <span className="flex items-center gap-1.5 text-xs font-medium px-2.5 py-1 rounded-full bg-blue-500/10 text-blue-400 border border-blue-500/20">
              <Code2 size={12} />
              Java
            </span>
            {isFetchedFromLeetCode && (
              <span className="flex items-center gap-1.5 text-xs font-medium px-2.5 py-1 rounded-full bg-orange-500/10 text-orange-400 border border-orange-500/20 animate-pulse-ring">
                <Globe size={10} /> Live from LeetCode
              </span>
            )}
            <span className="opacity-30">•</span>
            <span className="font-mono text-xs text-dark-muted/70">
              {problem.folder}
            </span>
          </div>
        </div>

        <motion.button
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
          onClick={toggleSolved}
          className={`flex items-center gap-2 px-4 md:px-5 py-2.5 rounded-xl border text-sm font-semibold transition-all shadow-lg ${
            solved
              ? "bg-gradient-to-r from-green-500/20 to-emerald-500/20 border-green-500/30 text-green-400 shadow-green-500/20"
              : "bg-dark-card border-dark-border text-dark-muted hover:border-brand-blue/50 hover:text-brand-blue hover:shadow-brand-blue/10"
          }`}
        >
          {solved ? (
            <CheckCircle2 size={18} className="animate-pulse" />
          ) : (
            <Circle size={18} />
          )}
          {solved ? "Solved!" : "Mark Solved"}
          {solved && <Zap size={14} className="text-yellow-400" />}
        </motion.button>
      </motion.div>

      {/* Tabs */}
      <div className="flex items-center border-b border-dark-border/50 px-4 md:px-6 bg-dark-card/50 backdrop-blur-sm z-10 overflow-x-auto">
        <TabButton
          active={activeTab === "description"}
          onClick={() => setActiveTab("description")}
          icon={<BookOpen size={16} />}
          label="Description"
        />
        <TabButton
          active={activeTab === "solution"}
          onClick={() => setActiveTab("solution")}
          icon={<Code2 size={16} />}
          label="Solution"
        />
      </div>

      {/* Content */}
      <div className="flex-1 overflow-y-auto p-0 scroll-smooth relative z-0">
        {loading ? (
          <div className="flex flex-col items-center justify-center min-h-[400px] text-brand-blue gap-4">
            <div className="relative">
              <div className="w-16 h-16 border-4 border-brand-blue/20 border-t-brand-blue rounded-full animate-spin"></div>
              <Award
                size={24}
                className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 text-brand-blue animate-pulse"
              />
            </div>
            <span className="text-sm text-dark-muted font-medium">
              Loading problem...
            </span>
          </div>
        ) : (
          <div className="p-4 md:p-8 max-w-5xl mx-auto">
            <AnimatePresence mode="wait">
              {activeTab === "description" && (
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                  transition={{ duration: 0.3 }}
                  key="desc"
                  className="leetcode-content prose prose-invert prose-lg max-w-none"
                >
                  <ReactMarkdown
                    rehypePlugins={[rehypeRaw]}
                    components={{
                      code({ node, inline, className, children, ...props }) {
                        const match = /language-(\w+)/.exec(className || "");
                        return !inline && match ? (
                          <div className="rounded-xl overflow-hidden border border-dark-border/50 my-6 shadow-2xl hover:shadow-brand-blue/10 transition-shadow">
                            <div className="px-4 py-2 bg-dark-card border-b border-dark-border/30 text-xs text-dark-muted font-mono flex items-center gap-2">
                              <Code2 size={12} />
                              {match[1]}
                            </div>
                            <SyntaxHighlighter
                              style={vscDarkPlus}
                              language={match[1]}
                              PreTag="div"
                              customStyle={{
                                margin: 0,
                                padding: "1.25rem",
                                background: "#0d0d0d",
                                fontSize: "0.9rem",
                              }}
                              {...props}
                            >
                              {String(children).replace(/\n$/, "")}
                            </SyntaxHighlighter>
                          </div>
                        ) : (
                          <code
                            className={`${className} bg-brand-blue/10 border border-brand-blue/20 px-2 py-0.5 rounded-md text-sm text-brand-blue font-mono`}
                            {...props}
                          >
                            {children}
                          </code>
                        );
                      },
                    }}
                  >
                    {data.readme}
                  </ReactMarkdown>
                </motion.div>
              )}

              {activeTab === "solution" && (
                <motion.div
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -20 }}
                  transition={{ duration: 0.3 }}
                  key="sol"
                >
                  <div className="rounded-2xl overflow-hidden border border-dark-border/50 bg-[#1e1e1e] shadow-2xl hover:shadow-brand-blue/10 transition-shadow">
                    <div className="px-4 py-3 border-b border-dark-border/30 bg-[#252526] text-xs font-mono flex items-center justify-between">
                      <div className="flex gap-2 items-center">
                        <div className="flex gap-2">
                          <div className="w-3 h-3 rounded-full bg-[#ff5f56] hover:bg-[#ff5f56]/80 transition-colors cursor-pointer"></div>
                          <div className="w-3 h-3 rounded-full bg-[#ffbd2e] hover:bg-[#ffbd2e]/80 transition-colors cursor-pointer"></div>
                          <div className="w-3 h-3 rounded-full bg-[#27c93f] hover:bg-[#27c93f]/80 transition-colors cursor-pointer"></div>
                        </div>
                        <span className="ml-3 text-dark-text/70 font-medium">
                          Solution.java
                        </span>
                      </div>
                      <div className="flex items-center gap-3">
                        <motion.button
                          whileHover={{ scale: 1.05 }}
                          whileTap={{ scale: 0.95 }}
                          onClick={copyCode}
                          className="flex items-center gap-2 px-3 py-1.5 hover:bg-white/10 rounded-lg transition-all text-dark-muted hover:text-white group"
                        >
                          {copied ? (
                            <Check size={14} className="text-green-500" />
                          ) : (
                            <Copy
                              size={14}
                              className="group-hover:scale-110 transition-transform"
                            />
                          )}
                          <span className="text-xs font-medium">
                            {copied ? "Copied!" : "Copy"}
                          </span>
                        </motion.button>
                        <span className="text-[10px] uppercase tracking-wider opacity-50 pl-3 border-l border-white/10">
                          Read-Only
                        </span>
                      </div>
                    </div>
                    <div className="overflow-x-auto">
                      <SyntaxHighlighter
                        language="java"
                        style={vscDarkPlus}
                        customStyle={{
                          margin: 0,
                          padding: "1.5rem",
                          background: "#1e1e1e",
                          fontSize: "14px",
                          lineHeight: "1.6",
                        }}
                        showLineNumbers={true}
                        lineNumberStyle={{
                          color: "#6e7681",
                          minWidth: "3.5em",
                          paddingRight: "1em",
                          textAlign: "right",
                          borderRight: "1px solid #333",
                          marginRight: "1em",
                          userSelect: "none",
                        }}
                      >
                        {data.code}
                      </SyntaxHighlighter>
                    </div>
                  </div>
                </motion.div>
              )}
            </AnimatePresence>
          </div>
        )}
      </div>
    </div>
  );
}

function TabButton({ active, onClick, icon, label }) {
  return (
    <button
      onClick={onClick}
      className={`
                flex items-center gap-2 px-4 md:px-6 py-4 text-sm font-semibold border-b-2 transition-all relative whitespace-nowrap
                ${
                  active
                    ? "border-brand-blue text-brand-blue"
                    : "border-transparent text-dark-muted hover:text-dark-text hover:border-dark-border"
                }
            `}
    >
      <motion.div
        whileHover={{ scale: 1.1, rotate: 5 }}
        whileTap={{ scale: 0.95 }}
      >
        {icon}
      </motion.div>
      {label}
      {active && (
        <motion.div
          layoutId="activeTabIndicator"
          className="absolute bottom-0 left-0 w-full h-[2px] bg-gradient-to-r from-brand-blue to-brand-purple shadow-[0_0_15px_rgba(59,130,246,0.5)]"
        />
      )}
    </button>
  );
}
