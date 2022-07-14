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
    public TreeNode helper(int[]in, int []po, int is, int ie, int ps, int pe){
        
        if(ps>pe|| is>ie)return null;
        // PostORDER last wala root
        TreeNode root = new TreeNode(po[pe]);
        int idx=is;
        while(in[idx]!=root.val)idx++;
        int count = idx-is; // left m element 
        root.left =helper(in, po,is, idx-1,ps,ps+count-1  );
        root.right=helper(in, po,idx+1, ie,ps+count,pe-1  );
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder, 0, inorder.length-1, 0, inorder.length-1);
    }
}
