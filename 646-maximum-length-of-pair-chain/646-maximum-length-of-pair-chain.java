class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
            return a[0]-b[0];
        });
        int max=1;
        int []dp = new int[pairs.length];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length ;i++){
            for(int j=0; j<=i-1; j++){
                if( pairs[i][0]>pairs[j][1]   && dp[j]+1 >dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;        
    }
}

