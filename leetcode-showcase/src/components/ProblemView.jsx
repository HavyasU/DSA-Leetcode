import React, { useState, useEffect } from "react";
import ReactMarkdown from "react-markdown";
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
          // 1. Try github first
          const githubData = await fetchProblemDetails(
            owner,
            repo,
            problem.folder,
          );
          let readme = githubData.readme;
          let fetchedFromLC = false;

          // 2. If weak readme, try leetcode direct
          if (
            !readme ||
            readme.length < 100 ||
            readme.includes("See `Solution.java`")
          ) {
            const slug = folderToSlug(problem.folder);
            // Note: this fetch might fail due to CORS if not proxied correctly or no session
            // but we try anyway.
            try {
              const lcData = await fetchProblemContent(slug);
              if (lcData && lcData.content) {
                readme = `<div class="leetcode-content">${lcData.content}</div>`;
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
    // Try to construct url.
    // folder: "001-TwoSum" -> "two-sum"
    const slug = folderToSlug(problem.folder);
    window.open(`https://leetcode.com/problems/${slug}/`, "_blank");
  };

  if (!problem) {
    return (
      <div className="flex-1 flex flex-col items-center justify-center text-dark-muted select-none bg-dark-bg/50 backdrop-blur-sm">
        <motion.div
          initial={{ scale: 0.9, opacity: 0 }}
          animate={{ scale: 1, opacity: 1 }}
          transition={{ duration: 0.5 }}
          className="w-24 h-24 bg-dark-card rounded-full flex items-center justify-center mb-6 shadow-[0_0_30px_rgba(0,0,0,0.3)] border border-dark-border"
        >
          <Code2 size={40} className="text-dark-muted opacity-50" />
        </motion.div>
        <p className="text-lg font-medium text-dark-text">
          Select a problem to view solution
        </p>
        <p className="text-sm text-dark-muted mt-2">
          Browse the list on the left to get started
        </p>
      </div>
    );
  }

  return (
    <div className="flex-1 flex flex-col h-screen overflow-hidden bg-dark-bg relative">
      {/* Background Mesh */}
      <div className="absolute inset-0 overflow-hidden pointer-events-none">
        <div className="absolute top-[-20%] right-[-10%] w-[500px] h-[500px] bg-brand-purple/10 rounded-full blur-[100px]" />
        <div className="absolute bottom-[-20%] left-[-10%] w-[500px] h-[500px] bg-brand-blue/10 rounded-full blur-[100px]" />
      </div>

      {/* Header */}
      <div className="border-b border-dark-border p-6 flex justify-between items-start bg-dark-bg/80 backdrop-blur-md sticky top-0 z-20 shadow-sm">
        <div>
          <div className="flex items-center gap-3 mb-2">
            <span className="font-mono text-xs font-bold px-2 py-1 rounded bg-dark-card border border-dark-border text-brand-purple">
              #{problem.id}
            </span>
            <h2 className="text-2xl font-bold text-white tracking-tight">
              {problem.title}
            </h2>
            <button
              onClick={openLeetCode}
              className="p-1.5 text-dark-muted hover:text-brand-blue transition-colors rounded hover:bg-white/5"
              title="Open in LeetCode"
            >
              <ExternalLink size={16} />
            </button>
          </div>
          <div className="flex gap-4 text-sm text-dark-muted items-center">
            <span className="flex items-center gap-1.5 text-xs font-medium px-2 py-0.5 rounded-full bg-blue-500/10 text-blue-400 border border-blue-500/20">
              Java
            </span>
            {isFetchedFromLeetCode && (
              <span className="flex items-center gap-1.5 text-xs font-medium px-2 py-0.5 rounded-full bg-orange-500/10 text-orange-400 border border-orange-500/20">
                <Globe size={10} /> Fetched from LeetCode
              </span>
            )}
            <span className="opacity-20">|</span>
            <span className="font-mono text-xs">{problem.folder}</span>
          </div>
        </div>

        <div className="flex items-center gap-3">
          <button
            onClick={toggleSolved}
            className={`flex items-center gap-2 px-4 py-2 rounded-lg border text-sm font-medium transition-all ${
              solved
                ? "bg-green-500/10 border-green-500/20 text-green-500 shadow-[0_0_15px_rgba(34,197,94,0.1)]"
                : "bg-dark-card border-dark-border text-dark-muted hover:border-brand-blue/50 hover:text-brand-blue hover:shadow-lg hover:shadow-brand-blue/5"
            }`}
          >
            {solved ? <CheckCircle2 size={16} /> : <Circle size={16} />}
            {solved ? "Solved" : "Mark as Solved"}
          </button>
        </div>
      </div>

      {/* Tabs */}
      <div className="flex items-center border-b border-dark-border px-6 bg-dark-bg/50 backdrop-blur-sm z-10">
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
      <div className="flex-1 overflow-y-auto p-0 scroll-smooth bg-dark-bg/30 relative z-0">
        {loading ? (
          <div className="flex flex-col items-center justify-center h-64 text-brand-blue gap-4">
            <Loader2 className="animate-spin" size={32} />
            <span className="text-sm text-dark-muted font-medium">
              Fetching contents...
            </span>
          </div>
        ) : (
          <div className="p-8 max-w-5xl mx-auto">
            <AnimatePresence mode="wait">
              {activeTab === "description" && (
                <motion.div
                  initial={{ opacity: 0, y: 10 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -10 }}
                  key="desc"
                  className="prose prose-invert prose-p:text-dark-text/90 prose-headings:text-white prose-strong:text-brand-blue prose-pre:bg-dark-card prose-pre:border prose-pre:border-dark-border max-w-none"
                >
                  {isFetchedFromLeetCode ? (
                    <div dangerouslySetInnerHTML={{ __html: data.readme }} />
                  ) : (
                    <ReactMarkdown
                      components={{
                        code({ node, inline, className, children, ...props }) {
                          const match = /language-(\w+)/.exec(className || "");
                          return !inline && match ? (
                            <div className="rounded-lg overflow-hidden border border-dark-border my-6 shadow-xl">
                              <div className="px-4 py-1.5 bg-dark-card border-b border-dark-border text-xs text-dark-muted font-mono">
                                {match[1]}
                              </div>
                              <SyntaxHighlighter
                                style={vscDarkPlus}
                                language={match[1]}
                                PreTag="div"
                                customStyle={{
                                  margin: 0,
                                  padding: "1rem",
                                  background: "#0d0d0d",
                                }}
                                {...props}
                              >
                                {String(children).replace(/\n$/, "")}
                              </SyntaxHighlighter>
                            </div>
                          ) : (
                            <code
                              className={`${className} bg-dark-card border border-dark-border px-1.5 py-0.5 rounded text-sm text-brand-purple font-mono`}
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
                  )}
                </motion.div>
              )}

              {activeTab === "solution" && (
                <motion.div
                  initial={{ opacity: 0, y: 10 }}
                  animate={{ opacity: 1, y: 0 }}
                  exit={{ opacity: 0, y: -10 }}
                  key="sol"
                  className="h-full"
                >
                  <div className="rounded-xl overflow-hidden border border-dark-border bg-[#1e1e1e] shadow-2xl relative group">
                    <div className="px-4 py-2 border-b border-dark-border bg-[#252526] text-xs text-dark-muted font-mono flex items-center justify-between">
                      <div className="flex gap-2 items-center">
                        <div className="w-3 h-3 rounded-full bg-[#ff5f56]"></div>
                        <div className="w-3 h-3 rounded-full bg-[#ffbd2e]"></div>
                        <div className="w-3 h-3 rounded-full bg-[#27c93f]"></div>
                        <span className="ml-2 text-dark-text opacity-70">
                          Solution.java
                        </span>
                      </div>
                      <div className="flex items-center gap-2">
                        <button
                          onClick={copyCode}
                          className="flex items-center gap-1.5 px-2 py-1 hover:bg-white/10 rounded transition-colors text-dark-muted hover:text-white"
                        >
                          {copied ? (
                            <Check size={12} className="text-green-500" />
                          ) : (
                            <Copy size={12} />
                          )}
                          <span className="text-[10px]">
                            {copied ? "Copied" : "Copy"}
                          </span>
                        </button>
                        <span className="text-[10px] uppercase tracking-wider opacity-60 pl-2 border-l border-white/10">
                          Read-Only
                        </span>
                      </div>
                    </div>
                    <SyntaxHighlighter
                      language="java"
                      style={vscDarkPlus}
                      customStyle={{
                        margin: 0,
                        padding: "1.5rem",
                        background: "#1e1e1e",
                        fontSize: "14px",
                        lineHeight: "1.5",
                      }}
                      showLineNumbers={true}
                      lineNumberStyle={{
                        color: "#6e7681",
                        minWidth: "3em",
                        paddingRight: "1em",
                        textAlign: "right",
                        borderRight: "1px solid #333",
                        marginRight: "1em",
                      }}
                    >
                      {data.code}
                    </SyntaxHighlighter>
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
                flex items-center gap-2 px-6 py-4 text-sm font-medium border-b-2 transition-all relative
                ${
                  active
                    ? "border-brand-blue text-brand-blue"
                    : "border-transparent text-dark-muted hover:text-dark-text hover:border-dark-border"
                }
            `}
    >
      {icon}
      {label}
      {active && (
        <motion.div
          layoutId="activeTab"
          className="absolute bottom-0 left-0 w-full h-[2px] bg-brand-blue shadow-[0_-1px_10px_rgba(59,130,246,0.5)]"
        />
      )}
    </button>
  );
}
