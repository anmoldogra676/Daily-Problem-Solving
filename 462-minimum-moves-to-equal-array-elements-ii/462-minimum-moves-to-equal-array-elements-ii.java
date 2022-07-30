class Solution {
    public int minMoves2(int[] arr) {
     Arrays.sort(arr);
     int n= arr.length/2;
     int ans=0;
     for(int a: arr)ans+= Math.abs(a-arr[n]);
     return ans;   
    }
}