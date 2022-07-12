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
    int ans=0;
    public void helper(TreeNode root, int sum){
        if(root==null)return ;
        if(root.left==null && root.right==null){
            ans+= sum*10+root.val;
           return; 
        }
        helper(root.left,sum*10+root.val);
        helper(root.right,sum*10+root.val);
        
        
    }
    public int sumNumbers(TreeNode root) {
        ans=0;
        helper(root, 0);
        return ans;
    }
}