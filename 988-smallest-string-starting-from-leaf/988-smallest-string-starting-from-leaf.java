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
    public String smallestFromLeaf(TreeNode root) {
        List<String>ls = new ArrayList<>();
        helper(root, ls, "");
        Collections.sort(ls);
        return ls.get(0);
    }
    public void helper(TreeNode root, List<String>ls, String s){
        if(root==null)return;
        
        char ch = (char)('a'+root.val);
        if(root.left==null && root.right==null){
            String ss = s+ch;
            String tt ="";
            for(int i=ss.length()-1;i>=0;i--){
                tt+=ss.charAt(i);
            }
            ls.add(tt);
            return;
        }
        helper(root.left, ls,s+ch);
        helper(root.right, ls,s+ch);
    }
    
}