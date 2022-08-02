class Solution {
    int an=1;
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        return helper(arr,limit);
    }
    public int helper(int []arr, int limit){
        int l=0;
        int h=arr.length-1;
        int val=0;
        while(l<h){
            if(arr[h]+arr[l]>limit){
                val++;
                h--;
            }else{
                val++;
                l++;
                h--;
            }
        }
        if(l==h)
             val++;
        return val;
    }
}