class Solution {
    public int findPaths(int m, int n, int maxMove, int s, int c) {
        int[][]arr = new int[m][n];
        mod=(int)(Math.pow(10,9))+7;
        Integer dp[][][]=new Integer [m][n][maxMove+1];
        int ans=helper(s,c,arr,maxMove,dp);
        return ans;
    }
    static int mod=0;
    public int helper(int s, int c, int[][]arr, int maxMove, Integer[][][]dp){
        int ans=0;
        if(s<0 ||s==arr.length || c<0 ||c==arr[0].length)
          return 1;
        if(maxMove==0)return 0;
       if(dp[s][c][maxMove]!=null)return dp[s][c][maxMove];
      int val1= helper(s+1,c, arr, maxMove-1,dp);
      int val2= helper(s-1,c,arr,maxMove-1,dp);
      int val3= helper(s,c+1,arr,maxMove-1,dp);
      int val4 =helper(s,c-1,arr,maxMove-1,dp);
      ans= ( (ans%mod) + (val1%mod))%mod; 
      ans= ( (ans%mod) + (val2%mod))%mod; 
      ans= ( (ans%mod) + (val3%mod))%mod; 
      ans= ( (ans%mod) + (val4%mod))%mod; 
      return dp[s][c][maxMove] =ans;
        
        
    }
    
}