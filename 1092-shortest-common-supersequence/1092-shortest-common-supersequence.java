class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2 ;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1 +dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // for(int []a :dp){
        //     for(int r: a){
        //         System.out.print(r+" ");
        //     }
        //     System.out.println();
        // }
        // fill the dp table 
        String ans ="";
        int n = n1;
        int m = n2;
        while(n>0 && m>0){
            if(s1.charAt(n-1)== s2.charAt(m-1)){
                ans+=s1.charAt(n-1);
                n--;
                m--;
            }else if(dp[n-1][m]>dp[n][m-1]){
                ans+= s1.charAt(n-1);
                n--;
            }else{
                ans+=s2.charAt(m-1);
                m--;
            }
        }
        while(n>0){
            ans+=s1.charAt(n-1);
                n--;
        }
        while(m>0){
             ans+= s2.charAt(m-1);
             m--;
        }
        String res ="";
        for(char ch: ans.toCharArray()){
            res=ch+res;
        }
        return res;
    }
}