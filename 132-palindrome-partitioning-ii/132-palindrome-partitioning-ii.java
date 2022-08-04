class Solution {
    public int minCut(String s) {
        int n= s.length();
        int [][]dp = new int[n+1][n+1];
        if(helper(s,0,s.length()-1))return 0;
        for(int[]a:dp)Arrays.fill(a,-1);
//         for(int i=s.length()-1;i>=0;i--){
//             for(int j=1 ;j<n;j++){
//                 if(i>=j)continue;
//                 int min=Integer.MAX_VALUE;
//                 for(int k=i;k<=j-1;k++){
//                    int res = 1+ dp[i][k]+dp[k+1][j];
//                    min=Math.min(min,res);
//                }
//                 dp[i][j]=min;
                
//             }
//         }
//         return dp[0][n-1];
        return h(0, s.length()-1, s,dp);
    }
     public boolean helper(String s,int i, int j){
       
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
    public int h(int i, int j, String s, int[][]dp){
        if(i>=j || helper(s,i,j))return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int k=i;k<=j-1;k++){
            int res=0;
            if(helper(s,i,k)){
                res = 1+ h(k+1, j, s,dp);
                min=Math.min(min,res);
            }  
        }
        return dp[i][j]=min;
    }
}