class Solution {
    public int coinChange(int[] arr, int amount) {
        // 
        int dp[][] = new int[arr.length][amount+1];
        int n=arr.length;
        // for(int []a: dp)Arrays.fill(a, -1);
        // int val= f(coins.length-1, amount, coins,dp);
        // if(val>= 100000)return -1;
        for(int i=0;i<n;i++)dp[i][0]=0;
        for(int i=1;i<dp[0].length ;i++){
            if(i%arr[0]==0)dp[0][i]= i/arr[0];
            else dp[0][i]=100000;
        }
        for(int i=1;i<arr.length;i++){
            for(int t=1;t<dp[0].length ;t++){
                int ta =100000;
        if(t-arr[i]>=0)
        ta = 1+ f(i, t-arr[i], arr,dp);
        int nt = 0+ f(i-1, t,arr,dp);
           dp[i][t]=Math.min(nt, ta);
            }
        }
        return dp[arr.length-1][amount]>=100000?-1:dp[arr.length-1][amount];
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