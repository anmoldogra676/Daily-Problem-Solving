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
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<TreeNode>tree= new LinkedList<>();
        List<Integer>ls = new ArrayList<>();
        tree.add(root);
        if(root==null)return ls;
        while(tree.size()>0){
            int size = tree.size();
            int temp=Integer.MIN_VALUE;
            while(size-->0){
                TreeNode node = tree.removeFirst();
                temp= Math.max(temp, node.val);
                if(node.left!=null)tree.add(node.left);
                if(node.right!=null)tree.add(node.right);
            }
            ls.add(temp);
        }
        return ls;
    }
}