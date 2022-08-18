class Solution {
    public int partitionDisjoint(int[] arr) {
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];
        left[0]=arr[0];
        right[arr.length-1]=arr[arr.length-1];
        for(int i=1;i <arr.length ;i++)left[i] = Math.max(left[i-1], arr[i]);
        for(int i=arr.length-2; i>=0;i--){
            right[i]=Math.min(arr[i], right[i+1]);
        }
        for(int i=1;i<arr.length ;i++){
            if(left[i-1] <=right[i])return i;
        }
        return -1;
        
    }
}
// 5 5 5 8 8
// 0 0 3 6 6
    
// 1 1 1 1 6 12
// 0 0 0 0 6 12