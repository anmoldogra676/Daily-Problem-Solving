class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int pr=1;
        for(int a: nums){
            pr =pr*a;
            ans=Math.max(pr, ans);
            if(pr==0)pr=1;
        }
        pr=1;
        for(int i=nums.length-1 ;i>=0;i--){
            int a = nums[i];
            pr =pr*a;
            ans=Math.max(pr, ans);
            if(pr==0)pr=1;
        }
        return ans;
    }
}

