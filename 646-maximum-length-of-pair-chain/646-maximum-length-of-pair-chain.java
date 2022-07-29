class Solution {
    public int findLongestChain(int[][] pairs) {
        // Also a variation of activity selection
        // max number of meeting in one Room 
        Arrays.sort(pairs,(a,b)->{
            return a[1]-b[1];
        });
        int ans=1;
        int l = pairs[0][1];
        for(int i=1;i<pairs.length ;i++){
            if(l<pairs[i][0]){
                ans++;
                l= pairs[i][1];
            }
        }
        return ans;
        // int max=1;
        // int []dp = new int[pairs.length];
        // Arrays.fill(dp,1);
        // for(int i=1;i<dp.length ;i++){
        //     for(int j=0; j<=i-1; j++){
        //         if( pairs[i][0]>pairs[j][1]   && dp[j]+1 >dp[i]){
        //             dp[i]=dp[j]+1;
        //         }
        //     }
        //     max=Math.max(dp[i],max);
        // }
        // return max;        
    }
}

