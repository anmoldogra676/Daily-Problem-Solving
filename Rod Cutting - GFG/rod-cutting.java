// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
    // Knapsack --> wt , val, w
    // --> unbounded
    int[][]dp=new int[price.length][n+1];
    for(int[]a:dp)Arrays.fill(a,-1);
    return helper(price, price.length-1,n,dp );
      
    }
    public int helper(int []arr, int n, int l, int[][]dp){
        
        if(n==0){
            return l*arr[0];
        }
        if(dp[n][l]!=-1)return dp[n][l];
        int nt =helper(arr, n-1, l,dp);
        int ta = Integer.MIN_VALUE;
        if(l-n-1>=0){
           ta= arr[n]+ helper(arr, n, l-n-1,dp);
        }
        return dp[n][l]=Math.max(nt, ta);
        
        
    }
}