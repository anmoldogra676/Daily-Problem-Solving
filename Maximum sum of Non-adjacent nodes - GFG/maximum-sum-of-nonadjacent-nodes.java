// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class MaxSum
{
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob = new Solution();
			    int ans = ob.getMaxSum(root);
			    System.out.println(ans);
                t--;
	        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution
{
    static class pair{
        int inc;
        int exc;
        pair(int inc, int exc){
            this.inc =inc;
            this.exc=exc;
        }
        pair(){
            
        }
    }
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        // add your code here
        // include and exclude 
        // node 2 cheeze mngwayunga 
        pair p = helper(root);
        return Math.max(p.inc, p.exc);
    }
    public static  pair helper(Node root){
        // include , exclude
        if(root==null){
            return new pair(0,0);
        }
        if(root.left==null && root.right==null){
            return new pair(root.data,0);
        }
        pair ls = helper(root.left);
        pair rs = helper(root.right);
        pair ans = new pair();
        ans.inc = root.data + ls.exc + rs.exc;
        ans.exc =  0 + Math.max(ls.inc,ls.exc) + Math.max(rs.inc, rs.exc);
        return ans;
    }
}
