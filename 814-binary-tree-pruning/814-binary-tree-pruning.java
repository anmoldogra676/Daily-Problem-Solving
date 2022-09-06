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
   static class pair{
        TreeNode ro=null;
        boolean flag=false;
        pair(TreeNode ro, boolean flag){
            this.ro=ro;
            this.flag=flag;
        }
        pair(){
            
        }
    }
    public  TreeNode pruneTree(TreeNode root) {
       pair p = helper(root);
        if(p.ro.left==null && p.ro.right==null){
            if(p.ro.val==0)return null;
        }
       return p.ro;
    }
    public  pair helper(TreeNode root){
        if(root==null)return new pair(null, false);
        if(root.left==null && root.right==null){
            if(root.val==1)
            return new pair(root, true);
            else return new pair(root, false);
        }
        pair le = helper(root.left);
        pair ri = helper(root.right);
        pair ans = new pair();
        ans.flag = (le.flag || ri.flag)||((root.val==1)?true:false);
        if(le.flag==false){
            root.left =null;      
        }
        if(ri.flag==false){
            root.right =null;
        }
        ans.ro= root;
        return ans;
    }
}