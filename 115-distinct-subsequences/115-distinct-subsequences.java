class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][]dp = new int[n][m];
        for(int[]a: dp)Arrays.fill(a,-1);
        return f(n-1,m-1,s,t,dp);
    }
    public int f(int n, int m, String s, String t,int[][]dp){
        if(m<0)return 1;
        if(n<0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            return dp[n][m]=f(n-1,m,s,t,dp)+ f(n-1,m-1,s,t,dp);
        }else{
            return dp[n][m]=f(n-1,m,s,t,dp);
        }
    }
}