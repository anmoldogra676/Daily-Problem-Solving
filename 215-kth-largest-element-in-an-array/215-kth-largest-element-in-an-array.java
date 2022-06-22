class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // T.c : O(nlogk)
        // PriorityQueue<Integer>pq = new PriorityQueue<>(); 
        // for(int i=0;i<nums.length ;i++){
        //      pq.add(nums[i]);
        //      if(pq.size()>k)
        //      pq.remove();
        // }
        // return pq.peek();
        // based upon quick Select
         k= nums.length-k;
        return helper(nums, k, 0,nums.length-1);
    }
    public int helper(int[]arr, int k ,int st, int end){
      
        int partitionIndex= helper2(arr, st ,end); // is idx k baad sb bde 
        if(partitionIndex==k){
            return arr[k];
        }else if(partitionIndex>k){
            return helper(arr, k, st, partitionIndex-1);
        }else{
             return helper(arr, k, partitionIndex+1, end);
        }
    
    }
    
    public int helper2(int[]arr, int st, int end){
        // Two pointer i, j, 
        // 0 to j-1 --> smaller
        // j to i-1 -->larger
        // i to end unknown
        int pivot = arr[end];
        int i=st;
        int j=st;
        while(i<= end){
            if(arr[i]>pivot){
                i++;
            }else{
                swap(arr, i ,j);
                i++;
                j++;
            }
        }
        
        return j-1;
    }
    public void swap(int []arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}