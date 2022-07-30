class Solution {
    public int minMoves2(int[] arr) {
        long ans=Long.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            long temp= 0;
            for(int j=0; j<arr.length ;j++){
                temp+=Math.abs((long)(arr[i])-(long)(arr[j]));
            }
            ans=Math.min(ans, temp);
        }
        return (int)ans;
    }
}