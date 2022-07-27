class Solution {
    // Another question on Pattern Matching
    public int minDistance(String word1, String word2) {
        Integer [][]dp = new Integer[word1.length()][word2.length()];
        return helper(word1, word2, word1.length()-1,word2.length()-1,dp);
    }
    public int helper(String s1, String s2, int n, int m, Integer[][]dp){
        
        if(m<0)return n+1;
        if(n<0)return m+1;
        if(dp[n][m]!=null)return dp[n][m] ;
        if(s1.charAt(n)==s2.charAt(m)){
            return dp[n][m]=helper(s1,s2, n-1,m-1,dp);
        }
        else{
            // 3 thing either insert, delete , replace
            return dp[n][m]=Math.min(1 + helper(s1, s2, n,m-1,dp), Math.min(1+helper(s1,s2,n-1,m-1,dp), 1+helper(s1, s2,n-1,m ,dp)));
        }
    }
}
 