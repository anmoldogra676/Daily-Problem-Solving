/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node ==null)return null;
        HashMap<Integer, Node >hs= new HashMap<>(); // integer k saamne uska clone ka node
        return helper(node,hs);   // expectation--> given node clone krke de dega
      // faith hai ki iske child bhi de denge 
        // work--> bs unke child k answers ko apne m add krwana hai 
    }
    
    public Node helper(Node node, HashMap<Integer, Node>hs){
        if(hs.containsKey(node.val))return hs.get(node.val);
        Node clone = new Node(node.val);
        hs.put(node.val, clone);
        for(Node temp: node.neighbors){
            Node nbrClone = helper(temp, hs);
            clone.neighbors.add(nbrClone);
        }
        return clone;
    }
    
}
