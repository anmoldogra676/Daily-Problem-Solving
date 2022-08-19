class Solution {
    public int maxSubArray(int[] nums) {
        int maxSumSoFar =Integer.MIN_VALUE;
        int csum=0;
        for(int a: nums){
            csum = Math.max(a, csum+a);
            maxSumSoFar=Math.max(maxSumSoFar, csum);
        }
        return maxSumSoFar;
    }
}
