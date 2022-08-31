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
class BSTIterator {
    public void helper(ArrayList<Integer>arr, TreeNode root){
        if(root==null)return;
        helper(arr, root.left);
        arr.add(root.val);
        helper(arr, root.right);
    }
    ArrayList<Integer>arr ;
    int i=0;
    public BSTIterator(TreeNode root) {
       arr = new ArrayList<>();
       helper(arr, root);
        i=0;
    }
    
    public int next() {
        int val= arr.get(i);
        i++;
        return val;
    }
    
    public boolean hasNext() {
        if(i<arr.size())return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */