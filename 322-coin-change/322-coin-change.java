class Solution {
    public int coinChange(int[] coins, int amount) {
        // 
        int dp[][] = new int[coins.length][amount+1];
        for(int []a: dp)Arrays.fill(a, -1);
        int val= f(coins.length-1, amount, coins,dp);
        if(val>= 100000)return -1;
        return val;
    }
    public int f(int i, int t, int []arr, int[][]dp){
        if(i==0){
            if(t%arr[i]==0)return t/arr[i];
            return 100000;
        }
        if(dp[i][t]!=-1)return dp[i][t];
        if(t==0)return dp[i][t]= 0;
        int ta =100000;
        if(t-arr[i]>=0)
        ta = 1+ f(i, t-arr[i], arr,dp);
        int nt = 0+ f(i-1, t,arr,dp);
        return dp[i][t]=Math.min(nt, ta);
        
    }
}