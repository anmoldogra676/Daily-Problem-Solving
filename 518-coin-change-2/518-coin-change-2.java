class Solution {
    public int change(int amount, int[] arr) {
        // f( amount , coins, n-1) --> coins array from starting 0 to n-1 kitne combination bn skte amount k
        int n=arr.length;
        int [][]dp = new int[n][amount+1];
        // for(int[]a:dp)Arrays.fill(a, -1);
        // return helper(amount, coins,n-1,dp);--->Memoization
        // tabulation-->
        // base case
        for(int i=0;i<=amount;i++){
            if(i%arr[0]==0)dp[0][i]=1;
        }
        // traverse
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j-arr[i]>=0)dp[i][j]+=dp[i][j-arr[i]];
            }
        }
        return dp[n-1][amount];
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