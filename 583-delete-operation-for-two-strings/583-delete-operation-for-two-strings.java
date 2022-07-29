class Solution {
    public int minDistance(String s1, String s2) {
        // lcs length
        return s1.length()+s2.length()-2*lcs(s1,s2);
    }
    public int lcs(String s1 , String s2){
        int [][]dp = new int[s1.length()][s2.length()];
        for(int []a: dp)Arrays.fill(a,-1);
        return h(s1, s2, s1.length()-1,s2.length()-1,dp);
    }
    public int h(String s1, String s2, int i, int j, int[][]dp){
        
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+ h(s1, s2, i-1, j-1,dp);
        }else{
            return dp[i][j]= Math.max(h(s1, s2, i-1, j,dp), h(s1, s2,i, j-1,dp));
        }
    }
}