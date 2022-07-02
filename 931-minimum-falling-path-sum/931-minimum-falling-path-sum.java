class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int m=  arr[0].length;
        int [][]dp = new int[n][m];
        // recursion m niche se uper ko ja rhe the 
        // base case 0 m the ab yahan pe ulta 
        for(int i =0;i<m;i++)dp[0][i]=arr[0][i];
        for(int i=1;i<arr.length ;i++){
            for(int j=0 ;j<arr[0].length ;j++){
                int up = dp[i-1][j];
                int lud = j-1>=0?dp[i-1][j-1]:Integer.MAX_VALUE;
                int rud = j+1<arr[0].length?dp[i-1][j+1]:Integer.MAX_VALUE;
                dp[i][j]=Math.min(up, Math.min(lud, rud)) + arr[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(min, dp[arr.length-1][i]);
        }
        return min;
        
        
    }
  
}