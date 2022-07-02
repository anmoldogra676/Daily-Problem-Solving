// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	   // minimum Sum Partition --> we have to do
	    int sum=0;
	    for(int a: arr)sum+=a;
	    boolean [][]dp = new boolean[n][sum+1];
	    for(int i=0 ;i<n;i++)dp[i][0]=true;
	    if(arr[0]<=sum )dp[0][arr[0]]=true;
	    for(int i=1 ;i<n;i++){
	        for(int j=1;j<=sum;j++){
	            boolean notTaken = dp[i-1][j];
	            boolean Taken= false;
	            if(j-arr[i]>=0){
	                Taken = dp[i-1][j-arr[i]];
	            }
	            dp[i][j]=Taken||notTaken;
	        }
	    }
	    int ans=Integer.MAX_VALUE;
	    for(int i=0 ;i<=sum ;i++){
	        if(dp[n-1][i]==true){
	            ans=Math.min(ans, Math.abs( i -(sum-i)   ));
	        }
	    }
	    return ans;
	} 
}
