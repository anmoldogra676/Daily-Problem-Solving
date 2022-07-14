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
    public int findTilt(TreeNode root) {
        // dfs recursion
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 0;
        int lefttilt = helper(root.left);
        int righttilt = helper(root.right);
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lefttilt +righttilt +Math.abs(lsum-rsum);
    
    }
    public int sum(TreeNode root){
        if(root==null)return 0;
        int ans=0;
        ans+=root.val;
        ans+=sum(root.left)+sum(root.right);
        return ans;
    }
}