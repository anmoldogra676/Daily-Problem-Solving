class Solution {
    public int minMoves(int[] arr) {
        Arrays.sort(arr);
        int res=0;
        for(int i=0;i<arr.length;i++){
            res+=arr[i]-arr[0];
        }
        return res;
    }
}