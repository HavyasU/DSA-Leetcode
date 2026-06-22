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
    int count;
    public int BFS(TreeNode root){
        if(root == null){
            return -1;
        }
        int val = BFS(root.left);
        if(val>-1){
            return val;
        }
        count--;
        if(count==0){
            return root.val;
        }
        return BFS(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        int val = BFS(root);
        return val;
    }
}