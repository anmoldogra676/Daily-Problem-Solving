class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res= 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // -4 -1 1 2
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int s = nums[i]+nums[j]+nums[k];
                if(s==target)return s;
                if(s>target){
                    if(s-target <diff){
                        diff= s-target;
                        res =s;
                    }
                    k--;
                }else{
                    if(target-s <diff){
                        diff = target-s;
                        res=s;
                    }
                    j++;
                }
            }
            
        }
        return res;
        
    }
}