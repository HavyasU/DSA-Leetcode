import React, { useState } from "react";
import { fetchStructure } from "./github";
import Sidebar from "./components/Sidebar";
import ProblemView from "./components/ProblemView";
import { Menu, X } from "lucide-react";
import { motion, AnimatePresence } from "framer-motion";

const OWNER = "HavyasU";
const REPO = "DSA-Leetcode";

export default function App() {
  const [problems, setProblems] = React.useState([]);
  const [selected, setSelected] = React.useState(null);
  const [loading, setLoading] = React.useState(true);
  const [search, setSearch] = React.useState("");
  const [sidebarOpen, setSidebarOpen] = useState(true);

  React.useEffect(() => {
    fetchStructure(OWNER, REPO).then((data) => {
      setProblems(data);
      setLoading(false);
    });
  }, []);

  return (
    <div className="flex h-screen overflow-hidden bg-dark-bg relative">
      {/* Mobile Menu Button - only show when closed */}
      {!sidebarOpen && (
        <button
          onClick={() => setSidebarOpen(true)}
          className="fixed top-4 left-4 z-50 lg:hidden bg-dark-card/50 backdrop-blur-md border border-dark-border/50 rounded-xl p-3 shadow-xl hover:bg-dark-card/70 hover:border-brand-blue/50 transition-all hover:scale-105 group"
          aria-label="Open menu"
        >
          <Menu
            size={20}
            className="text-dark-muted group-hover:text-brand-blue transition-colors"
          />
        </button>
      )}

      {/* Sidebar - responsive */}
      <AnimatePresence>
        {(sidebarOpen || window.innerWidth >= 1024) && (
          <>
            {/* Mobile overlay */}
            {sidebarOpen && (
              <motion.div
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                exit={{ opacity: 0 }}
                onClick={() => setSidebarOpen(false)}
                className="fixed inset-0 bg-black/50 backdrop-blur-sm z-30 lg:hidden"
              />
            )}

            {/* Sidebar */}
            <motion.div
              initial={{ x: -320 }}
              animate={{ x: 0 }}
              exit={{ x: -320 }}
              transition={{ type: "spring", damping: 25, stiffness: 200 }}
              className="fixed lg:relative inset-y-0 left-0 z-40 w-80 lg:w-80"
            >
              <Sidebar
                problems={problems}
                selected={selected}
                onSelect={(p) => {
                  setSelected(p);
                  setSidebarOpen(false);
                }}
                search={search}
                setSearch={setSearch}
                loading={loading}
                onClose={() => setSidebarOpen(false)}
              />
            </motion.div>
          </>
        )}
      </AnimatePresence>

      {/* Main content */}
      <div className="flex-1 overflow-hidden">
        <ProblemView problem={selected} owner={OWNER} repo={REPO} />
      </div>
    </div>
  );
}
