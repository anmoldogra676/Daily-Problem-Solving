class Solution {

    public int kInversePairs(int n, int k) {
        // int[][] dp = new int[n + 1][k + 1];
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j <= k; j++) {
        //         if (j == 0)
        //             dp[i][j] = 1;
        //         else {
        //             for (int p = 0; p <= Math.min(j, i - 1); p++)
        //                 dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
        //         }
        //     }
        // }
        // return dp[n][k];
        
         int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++){
            dp[i][0]=1; // jb k ki value 0 toh 1 answer hoga
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
                if(j-i>=0){
                    dp[i][j] = (dp[i][j] - dp[i-1][j-i] + 1000000007) % 1000000007; 
                }
            }
        }
        return dp[n][k];
        
        
        
    }
    // public int helper(int n, int k, Integer[][]dp){
    //     if(k==0)return 1;
    //     if(n==0)return 0;
    //     int ans=0;
    //     if(dp[n][k]!=null)return dp[n][k];
    //     for(int i=0;i<=Math.min(k,n-1);i++){
    //         ans= ( ans + helper(n-1,k-i,dp))%mod;
    //     }
    //     return dp[n][k]=ans;
    // }
    // 2 0
}