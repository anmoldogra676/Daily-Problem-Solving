class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][]dp = new int[nums1.length][nums2.length];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return helper(nums1.length-1,nums2.length-1,nums1, nums2,dp);
    }
    public int helper(int i, int j , int []arr1, int []arr2,int[][]dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(arr1[i]==arr2[j]){
            return dp[i][j]= 1 + helper(i-1,j-1,arr1, arr2,dp);
        }
        return dp[i][j]=Math.max(helper(i-1,j,arr1,arr2,dp),helper(i,j-1,arr1,arr2,dp));
        
        
    }
}