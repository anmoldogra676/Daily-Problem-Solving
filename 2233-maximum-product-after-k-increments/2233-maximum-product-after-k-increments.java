class Solution {
    public int maximumProduct(int[] nums, int k) {
      PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int a: nums)pq.add(a);
          
        while(k-->0){
            int val = pq.remove();
            val++;
            pq.add(val);
        }
        int m = (int)(1e9+7);
        long ans=1;
        while(pq.size()>0){
            ans = (ans*pq.remove())%m;
        }
        return (int)(ans);
        
    }
}


// 4 3 3 6 