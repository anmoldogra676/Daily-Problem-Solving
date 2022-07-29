class Solution {
    public int lengthOfLIS(int[] arr) {
        // faith and expectation
        // question comes of subsequence approach will be either to take it or not
        // 2 choices if take then keep track of prev element
        // return h(nums, 0, -1);
       
        // optimized approach
        // dp[i]--> length of longest increasing Subsequence ending at ith index
        int[]dp = new int[arr.length];
        int max=1;
        Arrays.fill(dp, 1);
        for(int i=1;i<dp.length ;i++){
            for(int j=i-1 ;j>=0 ;j--){
                if(arr[j]<arr[i] && 1+ dp[j] > dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
//     public int h(int []arr, int i, int prev){
        
//         if(i==arr.length)return 0;
        
//         // not take
//         int ans1 = h(arr, i+1, prev);
//         // take 
//         int ans2 =0;
//         if(  prev==-1 || arr[prev]<arr[i]){
//             ans2 = 1 + h(arr, i+1,i );
//         }
//         return Math.max(ans1, ans2);
        
//     } // O(n^2)
}