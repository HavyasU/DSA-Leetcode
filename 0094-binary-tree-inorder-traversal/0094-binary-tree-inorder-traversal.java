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
    public static void TraverseTree(List lst, TreeNode root){
        if(root==null){
            return;
        }

        TraverseTree(lst,root.left);
        lst.add(root.val);
        TraverseTree(lst,root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        TraverseTree(lst,root);
        return lst;
    }
}