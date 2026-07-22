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
    int maxdiameter = 0;
    int DFS(TreeNode node){
       if(node == null)
       return 0;

       int left = DFS(node.left);
       int right = DFS(node.right);
       maxdiameter = Math.max(maxdiameter,left+right);
       return 1+Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxdiameter =0;
        DFS(root);
        return maxdiameter;
    }
}