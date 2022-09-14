class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int csum=0;
        for(int a: nums){
            csum+=a;
            ans=Math.max(ans, csum);
            if(csum<0)csum=0;
            
        }
        return ans;
    }
}