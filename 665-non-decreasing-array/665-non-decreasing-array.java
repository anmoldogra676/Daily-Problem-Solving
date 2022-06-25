class Solution {
    public boolean checkPossibility(int[] nums) {
        int temp[]=nums.clone();
        for(int i= 0 ;i<nums.length-1 ;i++){
            if(temp[i]>temp[i+1]){
                temp[i]= temp[i+1];
                break;
            }
        }
        
        for(int i= 0 ;i<nums.length-1 ;i++){
            if(nums[i]>nums[i+1]){
                nums[i+1]= nums[i];
                break;
            }
        }
        return helper(temp)|| helper(nums);
   
        
    }
    public boolean helper(int[]nums){
        for(int i= 0 ;i<nums.length-1 ;i++){
            // System.out.println(c +" "+ nums[i] + " "+ nums[i+1]);
            if(nums[i]>nums[i+1]){
               return false;
            }
            
        }
        return true;
    }
}