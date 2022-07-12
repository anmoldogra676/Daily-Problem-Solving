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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // get all nodes at level k
        if(depth==1){
            TreeNode nn = new TreeNode(val);
            nn.left =root;
            nn.right=null;
            return nn;
        }
        ArrayList<TreeNode>arr1= new ArrayList<>();
        getNodeAtLevelK(root, depth-1, arr1);
        ArrayList<TreeNode>arr2= new ArrayList<>();
        getNodeAtLevelK(root, depth, arr2);
        System.out.println(arr1);
        // arr1 k left or right m add krunga 
        for(TreeNode node: arr1){
            if(node!=null){
            node.left = new TreeNode(val);
            node.right=new TreeNode(val);
            }
 
        }
        int i=0;
        for(TreeNode node: arr1){
            if(node!=null){
            node.left.left = arr2.get(i++);
            node.right.right=arr2.get(i++);
            }
 
        }
        
        System.out.println(arr2);
        return root;
    }
public void getNodeAtLevelK(TreeNode root, int d,ArrayList<TreeNode>arr1 ){
        if(d==1){
            arr1.add(root);
            return;
        }
    if(root==null)return;
       getNodeAtLevelK(root.left, d-1, arr1);
       getNodeAtLevelK(root.right, d-1, arr1);
    }
}