class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // we have to take 3 pointers
        Boolean[][]dp = new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length())return false;
        return helper(s1 ,s2,s3,0,0,dp);
    }
    public boolean helper(String s1, String s2, String s3, int i, int j,Boolean[][]dp){
        
        if(i== s1.length() && j==s2.length())return true;
        if(dp[i][j]!=null)return dp[i][j];
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            boolean val1 = helper(s1,s2,s3,i+1,j,dp);
              if(val1){
                  dp[i][j]=val1;
                  return true;
              }
        }
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            boolean val2 = helper(s1,s2,s3,i,j+1,dp);
            if(val2){
                dp[i][j]=val2;
                return true;
            }
        }
        return dp[i][j]=false;
        
        
    }
}

