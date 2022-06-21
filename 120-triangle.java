class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans =Integer.MIN_VALUE;
        int n= triangle.size();
        int[][]dp =new int[n][n];
        for(int []a:dp)Arrays.fill(a, -1);
        int val =  helper(0,0, triangle, dp);
        return val;
    }
    public int helper(int row,int col,  List<List<Integer>> triangle, int[][]dp){
        if(row== triangle.size()-1){
           
            return triangle.get(row).get(col);
            
        }
        if(dp[row][col]!=-1)return dp[row][col];
        int val= triangle.get(row).get(col);
        int val1 = val+ helper(row+1, col, triangle,dp);
        int val2 = val+ helper(row+1, col+1, triangle,dp);
        
        return dp[row][col]=Math.min(val1, val2);
    }
}