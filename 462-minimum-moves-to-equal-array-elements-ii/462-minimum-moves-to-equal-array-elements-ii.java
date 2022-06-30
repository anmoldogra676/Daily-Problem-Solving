class Solution {
    public int minMoves2(int[] nums) {
        // 1 2 9 10
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        int ans=0;
        for(int a: nums){
            ans+=Math.abs(a-mid);
        }
        return ans;
    }
}
