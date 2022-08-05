class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // hm khin se bhi partition kr skte hain 
        int []dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return h(0, k, arr, dp);
    }
    public int h(int i, int k, int []arr, int[]dp){
        if(i==arr.length)return 0;
        int len=0;
        int ans =Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        if(dp[i]!=-1)return dp[i];
        for(int j=i;j<Math.min(i+k,arr.length);j++){
            max=Math.max(max, arr[j]);
            len++;
            int res = max*len + h(j+1, k, arr,dp);
            ans=Math.max(ans, res);
        }
        return dp[i]=ans;
    }
}