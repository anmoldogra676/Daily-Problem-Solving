/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>ans = new ArrayList<>();
        LinkedList<Node>q = new LinkedList<>();
        q.add(root);
        if(root==null)return ans;
        while(q.size()>0)
        {
            int s= q.size();
            List<Integer>ls = new ArrayList<>();
            while(s-->0){
                Node p = q.removeFirst();
                ls.add(p.val);
                for(Node node : p.children){
                    if(node!=null)
                    q.add(node);
                }    
            }
            ans.add(ls);
        }
        return ans;
    }
}