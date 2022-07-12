class Solution {
    public int maximumScore(int[] nums, int[] mul) {
        
        Integer[][]dp = new Integer[nums.length][mul.length];
        return helper(nums,0, nums.length-1, mul, 0,dp);
    }
    public int helper(int[]arr, int i, int j, int[]mul , int k, Integer[][]dp){
        if(k==mul.length)return 0;
        int val1=0;
        int val2 =0;
        if(dp[i][k]!=null)return dp[i][k] ;
        val1+= arr[i]*mul[k] + helper(arr, i+1, j, mul, k+1,dp);
        val2+= arr[j]*mul[k] + helper(arr, i, j-1, mul, k+1,dp);
        
        return dp[i][k]= Math.max(val1,val2);
    }
}