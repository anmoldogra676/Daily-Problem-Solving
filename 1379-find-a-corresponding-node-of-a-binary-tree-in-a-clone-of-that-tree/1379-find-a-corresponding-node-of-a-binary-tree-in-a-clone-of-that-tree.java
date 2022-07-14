/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // find the node 
        return helper(cloned, target.val);
        
    }
    public TreeNode helper(final TreeNode root, int value){
        if(root==null)return null;
        if(root.val==value)return root;
        TreeNode temp =helper(root.left, value);
            if(temp!=null)return temp;
        TreeNode temp2 =helper(root.right, value);
        if(temp2!=null)return temp2;
        return null;
    }
}