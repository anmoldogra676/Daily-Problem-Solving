class Solution {
    public int change(int amount, int[] coins) {
        // f( amount , coins, n-1) --> coins array from starting 0 to n-1 kitne combination bn skte amount k
        int n=coins.length;
        int [][]dp = new int[n][amount+1];
        for(int[]a:dp)Arrays.fill(a, -1);
        return helper(amount, coins,n-1,dp);
        
    }
    public int helper(int a, int []arr, int n, int[][]dp){
        if(n==0){
            if(a%arr[0]==0)return 1;
            return 0;
        }
        if(dp[n][a]!=-1)return dp[n][a];
        int nt= helper(a, arr, n-1,dp);
        int tk=0;
        if(a-arr[n]>=0)
            tk+=helper(a-arr[n], arr, n,dp); // infinite supply so keep index as it is 
        return dp[n][a]=tk+nt;
    }
}