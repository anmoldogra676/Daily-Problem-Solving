class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int mid = arr[arr.length/2];
        int ans=0;
        for(int a: arr){
            ans+=Math.abs(a-mid);
        }
        return ans;
    }    
}


