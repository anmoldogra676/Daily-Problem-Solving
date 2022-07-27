class Solution {
    public boolean isMatch(String s, String p) {
      int n = s.length();
        int m = p.length();
        Boolean [][]dp = new Boolean[n][m];
        return f(n-1,m-1,s,p,dp);
    }
    public boolean f(int n, int m , String s, String p,Boolean[][]dp){
        
        if(n<0 && m<0){
            return true;
        }
        if(n>=0 && m<0){
            return false;
        }
        if(n<0 && m>=0){
            for(int k=m ;k>=0;k--){
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }
         if(dp[n][m]!=null)return dp[n][m];
        if(s.charAt(n)==p.charAt(m) || p.charAt(m)=='?'){
            return dp[n][m]= f(n-1,m-1,s,p,dp);
        }
        else if(p.charAt(m)=='*'){
            return dp[n][m]= f(n-1,m,s,p,dp) || f(n,m-1,s,p,dp);
        }
        return dp[n][m]=false;
        
        
    }
}