class Solution {
    public int minCost(int n, int[] cuts) {
        int []arr = new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        int r=1;
        for(int a: cuts)arr[r++]=a;
        Arrays.sort(arr);
        int [][]dp= new int[arr.length][arr.length];
        for(int []a:dp)Arrays.fill(a,-1);
        // cuts perform krne hai--> kahin pe bhi kr skta hn 
        return f(1, arr.length-2,arr,dp);
        
    }
    public int f(int i, int j, int []arr, int[][]dp){
        if(i>j)return 0;
        int mi = Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int m=i;m<=j;m++){
            int res = arr[j+1]-arr[i-1] + f(i,m-1,arr,dp)+f(m+1,j,arr,dp );
            mi =Math.min(mi, res);
        }
        return dp[i][j]=mi;
    }
}