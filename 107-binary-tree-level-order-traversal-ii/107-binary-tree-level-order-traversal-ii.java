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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode>ls = new LinkedList();
        if(root==null)return ans;
        ls.add(root);
        while(ls.size()>0){
            int s = ls.size();
            List<Integer>ls1 = new ArrayList<>();
            while(s-->0){
                TreeNode temp = ls.removeFirst();
                ls1.add(temp.val);
                if(temp.left!=null)ls.add(temp.left);
                if(temp.right!=null)ls.add(temp.right);
            }
           ans.add(0,ls1);
        }
        return ans;
    }
}