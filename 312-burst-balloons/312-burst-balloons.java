class Solution {
    public int maxCoins(int[] nums) {
        // instead of going from first do the reverse
        // last element that we have to burst 
        int []arr = new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        for(int i=0;i<nums.length ;i++){
            arr[i+1]=nums[i];
        }
        int [][]dp = new int [arr.length][arr.length];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        return h(1, arr.length-2, arr,dp);
        
    }
    public int h(int i, int j, int []arr,int[][]dp){
      
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int step =  arr[i-1]*arr[k]*arr[j+1]  +h(i, k-1, arr,dp)+ h(k+1, j,arr,dp);
            min=Math.max(min, step);
        }
        return dp[i][j]=min;
        
    }
    
}