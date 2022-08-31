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
    class pair{
        int sum;
        int size;
        pair(int sum,int size){
            this.sum= sum;
            this.size=size;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        int[]ans = new int[1];
        helper(root,ans);
        return ans[0];
    }
    public pair helper(TreeNode root,int []arr){
        if(root==null){
            return new pair(0,0);
        }
        
        pair left = helper(root.left, arr);
        pair right = helper(root.right, arr);
        pair p = new pair(0,0);
        int sum = left.sum+right.sum+root.val;
        int size = left.size + right.size+ 1;
        if(sum/size==root.val){
            arr[0]++;
        }
        p.sum= sum;
        p.size=size;
        return p;
    }
}