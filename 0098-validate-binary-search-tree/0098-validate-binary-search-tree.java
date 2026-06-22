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
    public static void Traverse(TreeNode root, List lst){
        if(root==null){
            return;
        }
        Traverse(root.left,lst);
        lst.add(root.val);
        Traverse(root.right,lst);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        Traverse(root,lst);
        int n = lst.size();
        for(int i=0;i<n-1;i++){
            if(lst.get(i)>=lst.get(i+1)){
                return false;
            }
        }

        return true;
    }
}