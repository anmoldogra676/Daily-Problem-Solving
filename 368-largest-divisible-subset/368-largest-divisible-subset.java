class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int [] dp = new int[nums.length];
        int [] hash = new int[nums.length];
        hash[0]=0;
        int max=1;
        int last_index=0;
        Arrays.fill(dp, 1);
        for(int i=1;i<dp.length;i++){
            hash[i]=i;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && dp[i] <dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i] =j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
            last_index =i;
            }
            
        }
        // System.out.println(max + ", "+ last_index);
        List<Integer>ans = new ArrayList<>();
        while(hash[last_index]!=last_index){
            ans.add(nums[last_index]);
            last_index = hash[last_index];
        }
        ans.add(nums[last_index]);
        Collections.reverse(ans);
        return ans;
    }
}

// set of numbers is given to me 
// largest subset such that every pair  
// subset --> element kisi bhi order m aa skte hain 
// if we want to convert this into subsequence
// sort krna pdega 
// 1 2 4 8
// now we have find longest divisible subsequence
// dp[i]---> length of longest divisble subsequence upto index i