// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public int helper(Node n){
        if(n==null)return 0;
        int l = helper(n.left);
        int r = helper(n.right);
        return l+r+1;
    }
    public boolean helper1(Node node, int n,int i){
        if(node==null)return true;
        if(i>=n)return false;
        return helper1(node.left,n, 2*i+1 ) && helper1(node.right , n, 2*i+2);
    }
    public boolean helper3(Node n, int i){
        if(n==null)return true;
        if(n.left==null && n.right==null)return true;
        int left = n.left!=null ?n.left.data:0;
        int right = n.right!=null? n.right.data:0;
        int val=Math.max(left, right);
        return n.data >=val && helper3(n.left, 2*i+1)&& helper3(n.left, 2*i+2);
        
    }
    boolean isHeap(Node tree) {
        // code here
        // for Tree to heap --> 2 things 1. CBT 2. all small
        if(tree==null)return true;
        int n = helper(tree);
        boolean res1 = helper1(tree, n, 0);
        if(!res1)return false;
        boolean res2 = helper3(tree,0);
        return res2;
        
        
    }
}