class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        /// unhi pe ladder ko use krna chahunga jahan max jump lena pde
        for(int i=0;i<heights.length-1 ;i++){
            if(heights[i]>=heights[i+1]){
                continue;
            }else{
                int gap = heights[i+1]-heights[i];
                pq.add(gap);
                if(pq.size()>ladders){
                    // gdbd;
                    int min = pq.remove();
                    if(min>bricks)return i;
                    bricks-=min;
                }
            }
            
            
        }
        return heights.length-1;
    }
}