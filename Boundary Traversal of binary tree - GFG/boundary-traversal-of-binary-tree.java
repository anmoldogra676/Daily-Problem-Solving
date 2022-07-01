// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public void printLeft(Node node,ArrayList<Integer>ls){
        if(node==null)return;
        if(node.left==null && node.right==null)return;
        ls.add(node.data);
        if(node.left!=null)
        printLeft(node.left, ls );
        else if(node.right!=null)
        printLeft(node.right, ls);
    }
    
    public void printRight(Node node,ArrayList<Integer>ls){
        if(node==null)return;
        if(node.left==null && node.right==null)return;
        if(node.right!=null)
          printRight(node.right, ls );
        else if(node.left!=null)
          printRight(node.left, ls);
        ls.add(node.data);
    }
    public void printLeaf(Node node,ArrayList<Integer>ls){
        if(node==null)return;
        printLeaf(node.left, ls );
        if(node.left==null && node.right==null){
            ls.add(node.data);
        }
        printLeaf(node.right, ls);
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	 
	 ArrayList<Integer>ls = new ArrayList<>();
	 ls.add(node.data);
	 if(node.left==null && node.right==null)return ls;
	 printLeft(node.left,ls );
	 printLeaf(node.left,ls);
	 printLeaf(node.right,ls);
	 printRight(node.right, ls);
	 return ls;
	}
}
