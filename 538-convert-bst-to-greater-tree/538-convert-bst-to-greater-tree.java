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
    static int sum=0;
    public TreeNode convertBST(TreeNode root) {
        // I have to keep a varible sum by which I can traverse the many things
        if(root==null || root.left==null&& root.right==null)return root;
        sum=0;
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root==null)return ;
        helper(root.right);
        sum+=root.val;
        root.val =sum;
        helper(root.left);
        
    }
}