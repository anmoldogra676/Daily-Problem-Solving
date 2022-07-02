class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    //add + - 
   //+ ek subset m - walo ko dusre m 
        // count subset diff ==>0
        // s1-s2 =t
        //  2s1 =t + d
         int sum=0;
        for(int a: nums)sum+=a;
        if( (sum+target )%2==0){
            return helper(nums.length-1, (target+sum )/2, nums);
        }
        return 0;
        
    }
    // count of subset having sum -->s
    public int helper(int n, int s, int[]arr){
        
        if(n==0){
            if(s==0 && arr[0]==0)return 2;
            if(s==0 || s==arr[n])return 1;
            return 0;
        }
        int nt = helper(n-1, s,arr);
        int ta =0;
        if(s-arr[n]>=0)
            ta = helper(n-1, s-arr[n], arr);
        return nt+ta;
    }
}