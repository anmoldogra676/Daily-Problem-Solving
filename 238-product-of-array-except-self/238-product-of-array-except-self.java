class Solution {
    public int[] productExceptSelf(int[] arr) {
        int left[] = new int[arr.length];
        int right[] =new int[arr.length];
        left[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            left[i] = left[i-1]*arr[i];
        }
        right[arr.length-1] = arr[arr.length-1];
        for(int i= arr.length-2;i>=0;i--){
            right[i] = right[i+1]*arr[i];
        }
        arr[0] =right[1];
        for(int i =1; i<arr.length-1 ;i++){
            arr[i] = left[i-1]*right[i+1];
        }
        arr[arr.length-1] = left[arr.length-2];
        return arr;
    }
}
// 1 2 6 24
// 24 24 12 4
