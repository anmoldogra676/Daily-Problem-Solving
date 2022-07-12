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
        int p=10;
        if(root==null)return ;
        
        if(root.left==null && root.right==null){
            System.out.println(sum +" "+ p);
          int val = sum*p+root.val;
            ans+=val;
           return; 
        }
        
        if(root.left!=null){
            int save =sum;
            int val = sum*p+root.val;
            helper(root.left,val);
            sum=save;
        }
        
          if(root.right!=null){
            int save =sum;
            int val = sum*p+root.val;
            helper(root.right,val);
            sum=save;
        }
        
    }
    public int sumNumbers(TreeNode root) {
        ans=0;
         helper(root, 0);
             return ans;
    }
}