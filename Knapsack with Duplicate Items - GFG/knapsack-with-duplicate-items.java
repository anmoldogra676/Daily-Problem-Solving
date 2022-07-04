// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here
        int [][]dp  = new int[n][w+1];
        for(int []a: dp)Arrays.fill(a, -1);
        return helper(n-1, w,val, wt,dp );
    }
    public static int helper(int n, int wt, int []val , int[]arr, int [][]dp){
        
        if(n==0){
            return (wt/arr[0])*val[0];
        }
        if(dp[n][wt]!=-1)return dp[n][wt];
        int nt = helper(n-1, wt, val, arr,dp);
        int ta=Integer.MIN_VALUE;
        if(wt-arr[n]>=0){
            ta = val[n]+helper(n, wt-arr[n], val, arr,dp);
        }
        return dp[n][wt]=Math.max(nt,ta);
    }
}