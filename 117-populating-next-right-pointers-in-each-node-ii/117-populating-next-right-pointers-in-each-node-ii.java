/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       if(root==null)return root;
        if(root.left==null && root.right==null){
            root.next = null;
            return root;
        }
        LinkedList<Node>ls = new LinkedList<>();
        ls.add(root);
        while(ls.size()>0){
            int s=ls.size();
            Node save=null;
            for(int i=1;i<=s;i++){
                Node rm = ls.removeFirst();
                
                if(save!=null){
                    save.next=rm;
                    save=save.next;
                }
                else save=rm;
                if(i==s){
                    if(rm.left!=null)ls.add(rm.left);
                    if(rm.right!=null)ls.add(rm.right);
                    save.next=null;
                    continue;
                }
                if(rm.left!=null)ls.add(rm.left);
                if(rm.right!=null)ls.add(rm.right);
                
            }
            
        }
        return root;  
    }
}