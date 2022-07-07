class Solution {
    public boolean canReach(int[] arr, int start) {
        Boolean[]dp= new Boolean[arr.length];
        HashSet<Integer>hs =new HashSet<>();
        return helper(arr, start,dp,hs);
    }
    public boolean helper(int[]arr, int i,Boolean[]dp,HashSet<Integer>hs){
        if(i>=arr.length || i<0)return false;
        if(hs.size()>0 && hs.contains(i))return dp[i]!=null?dp[i]:false;
        if(arr[i]==0)return true;
        if(dp[i]!=null)return dp[i];
        hs.add(i);
        return dp[i]=helper(arr, i+arr[i],dp,hs)|| helper(arr, i-arr[i],dp,hs);
    }
}