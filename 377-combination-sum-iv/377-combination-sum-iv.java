class Solution {
    public int combinationSum4(int[] arr, int t) {
        dp= new int[t+1];
        Arrays.fill(dp, -1);
        return helper(arr, t,dp);
    }
    int[]dp;
    public int helper(int[]arr, int t, int[]dp){
        if(t<0 )return 0;
        if(t==0)return 1;
        int ans=0;
        if(dp[t]!=-1) return dp[t];
        for(int i=0;i<arr.length;i++){
            ans+= helper(arr, t-arr[i],dp);
        }
        return dp[t]=ans;
    }
}