class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int res1 = helper(nums, firstLen, secondLen);
        int res2 = helper(nums, secondLen, firstLen);
        return Math.max(res1, res2);
    }
    public int helper(int []arr, int f, int s){
        int []left = new int[arr.length];
        int sum=0;
        // contructing the left array contains max sum of subarray of length f
        for(int i=0;i<left.length;i++){
            sum+=arr[i];
            if(i==f-1){
                left[i]=sum;
            }else if(i>f-1){
                sum-=arr[i-f];
                left[i]=Math.max(sum, left[i-1]);
            }
            
        }
        // same thing we have to do from right of size s 
        int []right = new int[arr.length];
        sum=0;
        for(int i=arr.length-1;i>=0;i--){
            sum+=arr[i];
            if(i==arr.length-s ){
                right[i]=sum;
            }else if(i<arr.length-s){
                sum-= arr[i+s];
                right[i]=Math.max(sum, right[i+1]);
            }
        }
        // now calculate result 
        int ans=0;
        for(int i=f-1 ;i<arr.length-s ;i++){
            ans=Math.max(ans, left[i]+right[i+1]);
        }
        return ans;
        
    } // 8
}