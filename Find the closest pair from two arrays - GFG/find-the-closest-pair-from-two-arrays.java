//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(arr[0]);
        ans.add(brr[0]);
        int i=0;
        int j=m-1;
        while(i<n && j>=0){
            int sum= arr[i]+brr[j];
            
            if(sum <=x){
                // closed pair found
                int s = ans.get(0)+ans.get(1);
               // System.out.println(sum+ " "+ s);
                if(Math.abs(s-x)>Math.abs(sum-x)){
                ans.set(0,arr[i]);
                ans.set(1,brr[j]);
                
                }
                i++;
            }else{
                 int s = ans.get(0)+ans.get(1);
               // System.out.println(sum+ " "+ s);
                if(Math.abs(s-x)>Math.abs(sum-x)){
                ans.set(0,arr[i]);
                ans.set(1,brr[j]);
                
                }
                j--;
            }
        }
        return ans;
    }
}