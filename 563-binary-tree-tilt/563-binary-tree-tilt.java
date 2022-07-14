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
class Solution { // 0(n2)
    class pair{
        int tilt;
        int sum;
        pair(int tilt, int sum){
            this.tilt=tilt;
            this.sum=sum;
        }
        pair(){
            
        }
    }
    public int findTilt(TreeNode root) {
        // dfs recursion
        pair p =helper(root);
        return p.tilt;
    }
    
    public pair helper(TreeNode root){
        if(root==null){
            return new pair(0,0);
        }
        if(root.left==null && root.right==null){
            return new pair(0,root.val);
        }
        pair l = helper(root.left);
        pair r = helper(root.right);
        pair m = new pair();
        // tilt , sum
        m.sum = l.sum+r.sum+ root.val;
        m.tilt = l.tilt +r.tilt + Math.abs(l.sum-r.sum);
        return m;
        
    }
    
    
//     public int helper(TreeNode root){
//         if(root==null)return 0;
//         if(root.left==null && root.right==null)return 0;
//         int lefttilt = helper(root.left);
//         int righttilt = helper(root.right);
//         int lsum = sum(root.left);
//         int rsum = sum(root.right);
//         return lefttilt +righttilt +Math.abs(lsum-rsum);
    
//     }
//     public int sum(TreeNode root){  // o(n)
//         if(root==null)return 0;
//         int ans=0;
//         ans+=root.val;
//         ans+=sum(root.left)+sum(root.right);
//         return ans;
//     }
}