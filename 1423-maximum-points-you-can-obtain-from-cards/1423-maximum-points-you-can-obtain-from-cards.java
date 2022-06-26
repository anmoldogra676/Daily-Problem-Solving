class Solution {
    public int maxScore(int[] arr, int k) {
        // question Gist --> longest subarray of size k having minimum sum
        k= arr.length-k;
        int fsum = 0;
        for(int a: arr)fsum+=a;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        min=Math.min(sum,min);
        for(int i=k;i<arr.length ;i++){
            sum = sum+arr[i]-arr[i-k];
            min=Math.min(min,sum);
        }
        
        return fsum-min;
    }
}