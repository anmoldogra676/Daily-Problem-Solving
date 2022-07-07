class Solution {
    public int jump(int[] arr) {
       if(arr.length==1)return 0;
        int[]dp = new int[arr.length];
        Arrays.fill(dp ,-1);
       return helper(arr, 0,dp);   
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