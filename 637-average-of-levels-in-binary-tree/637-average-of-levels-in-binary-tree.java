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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans = new ArrayList<>();
        LinkedList<TreeNode>ls = new LinkedList();
        ls.add(root);
        while(ls.size()>0){
            int s = ls.size();
            long sum=0;
            int t =s;
            while(s-->0){
                TreeNode temp = ls.removeFirst();
                sum+=temp.val;
                if(temp.left!=null)ls.add(temp.left);
                if(temp.right!=null)ls.add(temp.right);
            }
            ans.add( (sum*1.0)/t);
        }
        return ans;
    }
}