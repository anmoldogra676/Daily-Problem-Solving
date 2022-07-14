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
    public TreeNode buildTree(int[] pre, int[] in) {
     
        return helper(pre, in, 0, in.length-1, 0, in.length-1);
        //                     ins   in end    pres.  pre end
    }
    public TreeNode helper(int[]pre, int []in, int ins, int ine, int prs, int pree){
        
        if(prs>pree || ins >ine)return null;
        TreeNode root = new TreeNode(pre[prs]);
        int idx = ins;
        while(in[idx]!=root.val){
            idx++;
        }
        int count = idx-ins;
        root.left = helper(pre,in,ins, idx-1,prs+1, prs+count );
        root.right = helper(pre, in,idx+1, ine ,prs+count+1,pree );
        return root;
        
    }
}

// --> root
// left    right 

// preorder = [3,9,20,15,7] --> Root left, right
// inorder = [9,3,15,20,7]  --> left root right