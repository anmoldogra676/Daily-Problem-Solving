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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        LinkedList<TreeNode>q = new LinkedList<>();
        q.add(root);
        if(root==null)return ans;
        while(q.size()>0)
        {
            int s= q.size();
            List<Integer>ls = new ArrayList<>();
            while(s-->0){
                TreeNode p = q.removeFirst();
                ls.add(p.val);
                if(p.left!=null)
                q.add(p.left);
                if(p.right!=null)
                q.add(p.right);
            }
            ans.add(ls);
        }
        return ans;
    }
}