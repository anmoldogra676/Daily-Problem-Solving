class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
		//step:1 find the longest increasing subsequences till i
        int[] lis = new int[n];
        
        for (int i = 0; i < n; i++){
            int max = 1;
            for (int j = i-1;j >= 0; j--){
                if (nums[j] < nums[i]){
                    max = Math.max(max, lis[j] + 1);
                }
            }
             lis[i] = max;
        }
        
		//step : 2 find longest decreasing subsequence starting from i
        int[] lds = new int[n];
        for (int i = n-1; i >= 0; i--){
            int max = 1;
            for (int j = i+1; j < n; j++){
                if (nums[i] > nums[j]){
                    max = Math.max(max, lds[j]+ 1);
                }
            }
            lds[i] = max;
        }
        
		/*step 3: now find longest bitonic subsequence 
		but ensure that there something on the left and right of a particular index i 
		inorder to make it a mountain  which means lis[i] > 1 and lds[i] > 1
		*/
        int lbs = 0;
        for (int i = 0; i < n; i++){
            if (lis[i] > 1 && lds[i] > 1)
            lbs = Math.max(lis[i] + lds[i]-1, lbs);
        }
		//step 4: min remove is size of the original array - the length of the longest bitonic subsequence found
        return n - lbs;
    }
}