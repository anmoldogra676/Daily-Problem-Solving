class Solution {
    public boolean makesquare(int[] arr) {
        return canPartitionKSubsets(arr, 4);
    }
     public boolean canPartitionKSubsets(int[] arr, int k) {
        int sum=0;
        for(int a:arr)sum+=a;
        if(sum%k!=0)return false;
        if(arr.length<k)return false;
        int tar = sum/k;
        boolean[]used = new boolean[arr.length];
        return helper(arr, 0, tar, k, used, 0);
        
    }
    public boolean helper(int[]arr, int st, int tar, int k, boolean[]used ,int sum){
        if(k==0)return true;
        if(sum==tar){
            return helper(arr, 0, tar,k-1, used, 0);
        }
        for(int i=st;i<arr.length;i++){
            if(used[i] || sum+arr[i]>tar )continue;
            used[i]=true;
            if(helper(arr, i+1, tar, k, used, sum+arr[i]))return true;
            used[i]=false;
        }
        return false;
    }
}