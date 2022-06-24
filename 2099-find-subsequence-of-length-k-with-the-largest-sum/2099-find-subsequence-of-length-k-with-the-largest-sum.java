class Solution {
    // Brute Force
    
    public int[] maxSubsequence(int[] nums, int k) {
        int[]ans= new int[k];
        // ArrayList<Integer>arr =new ArrayList<>();
        // int []sum = new int[1];
        // sum[0]=Integer.MIN_VALUE;
        // helper(nums ,0,arr ,k ,sum);
        //--> Logic --> k largest element agr nikal lenge toh sum bhi largest hoga 
        // toh start se agr shuru krein toh ordering ki tension khtm aur k largest bhi aa gye 
        
        
        PriorityQueue<int[]>pq = new PriorityQueue<int[]>((a,b)->{
            return a[0]-b[0];
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
            if(pq.size()>k){
                pq.remove();
            }
        }
        Set<Integer>hs = new HashSet<>();
        while(pq.size()>0){
            int idx = pq.remove()[1];
            hs.add(idx);
        }
        k=0;
        for(int i=0;i<nums.length;i++){
            if(hs.contains(i)){
                ans[k++]=nums[i];
            }
        }
        
        
        return ans;
    }

//     public void helper(int []arr ,int idx, ArrayList<Integer>temp,int k, int []sum){
//         if(temp.size()==k){
//             int val=0;
//             for(int a: temp)val+=a;
//             if(val>sum[0]){
//                 for(int i=0 ;i<k;i++){
//                     ans[i]=temp.get(i);
//                 }
//                 sum[0]=val;
//             }
//             return;
//         }
//         if(idx==arr.length)return;
//         temp.add(arr[idx]);
//         helper(arr, idx+1, temp, k, sum);
//         temp.remove(temp.size()-1);
//         helper(arr, idx+1, temp, k,sum);
        
//     }
}
