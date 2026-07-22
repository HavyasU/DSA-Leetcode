/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int minDiff = Integer.MAX_VALUE;
    int last = -1;
    void DFS(TreeNode node){
        if(node == null) return;
        int cur = node.val;
        DFS(node.left);
        if(last!=-1)
        minDiff = Math.min(minDiff, Math.abs(last-cur));
        last = cur;
        DFS(node.right);
    }
    public int getMinimumDifference(TreeNode root) {
        DFS(root);
        return minDiff;
    }
}