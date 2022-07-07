class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
       if(arr.length==1)return 0;
        int[]dp = new int[arr.length];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int min= 100000;
            for(int j=1;j<=arr[i]&& i+j<arr.length;j++){
                min=Math.min(min, 1+dp[i+j]);
            }
            dp[i]=min;
        }
        return dp[0];
       // return helper(arr, 0,dp);   
    }
    public int helper(int []arr, int i, int[]dp){
        if(i==arr.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int min= 10000000;
        for(int j=1;j<=arr[i]&& i+j <arr.length ;j++){
            int val = helper(arr, i+j, dp);
            min=Math.min(min ,1+val);
        }
        return dp[i]= min;
    }
}