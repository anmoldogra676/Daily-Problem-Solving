// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    static class Node{
        int val;
        int r;
        int c;
        Node(int val, int r, int c){
            this.val=val;
            this.r=r;
            this.c=c;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
    // Brute force--> ek array m store krke sort krdo aur mil jayega result    
        
    // Isko Pq se krte hain --> K lements ko add
    // uske baad check krke ki jisko remove kiya uska index
    // T.c -> O(k*k log k). s.c.-> O(k)
    PriorityQueue<Node>pq = new PriorityQueue<>( (a,b)->{
        return a.val-b.val;
    } );
    for(int i=0;i<K;i++){
        pq.add(new Node(arr[i][0], i, 0));  // k elements ko daal diya
    }
    ArrayList<Integer>ans = new ArrayList<>();
    while(pq.size()>0){
        Node n =pq.remove();
        ans.add(n.val);
        if(n.c+1<arr[n.r].length){
            pq.add(new Node(arr[n.r][n.c+1], n.r,n.c+1));
        }
    }
    return ans;
        
        
    }
}