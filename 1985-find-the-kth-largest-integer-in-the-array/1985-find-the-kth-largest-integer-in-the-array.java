class Solution {
    // Custom Sort ->>O(nlogn)Time
    // Same thing can be done by Min Prioroty Queue
    // Quick Select --> Parttion in Quick Sort ( based upon end element we find partition Index)
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a,b)->{
            if(a.length()!=b.length())return a.length()-b.length();
            return a.compareTo(b);
        });
        return nums[nums.length-k];
        
    }
}