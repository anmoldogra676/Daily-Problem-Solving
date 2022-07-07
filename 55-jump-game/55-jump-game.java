class Solution {
    public boolean canJump(int[] arr)
    {
        if(arr.length==1)return true;
        Boolean[]dp = new Boolean[arr.length];
        if(arr[0]==0)return false;
       return helper(arr, 0,dp);   
    }
    public boolean helper(int []arr, int i, Boolean[]dp){
        if(i==arr.length-1)return true;
        if(dp[i]!=null)return dp[i];
        for(int j=1;j<=arr[i]&& i+j <arr.length ;j++){
            if(helper(arr, i+j,dp))return true;
        }
        return dp[i]= false;
    }
}