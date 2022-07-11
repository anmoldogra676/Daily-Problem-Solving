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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
      LinkedList<TreeNode>ls = new LinkedList<>();
      if(root==null)return ans;
      ls.add(root);
      while(ls.size()>0){
          int s = ls.size();
          for(int i=0; i<s;i++){
              TreeNode nn = ls.removeFirst();
              if(nn.left!=null)ls.add(nn.left);
              if(nn.right!=null)ls.add(nn.right);
              if(i==s-1){
                  ans.add(nn.val);
              }
          }
      }
      return ans;
    }
}