class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>ls = new ArrayList<>();
        PriorityQueue<int[]>pq = new PriorityQueue<int[]>((a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return b[0]-a[0];
        });
        // array modify 
        int temp[] = new int[arr.length];
        for(int i=0 ;i<arr.length ;i++){
            temp[i]=arr[i];
            arr[i]=Math.abs(arr[i]-x);
        }
        for(int i=0;i<arr.length ;i++){
            pq.add(new int[]{arr[i],i});
            if(pq.size()>k)pq.remove();
        }
        Set<Integer>st = new HashSet<>();
        while(pq.size()>0){
            st.add(pq.remove()[1]);
        }
        for(int i=0;i<temp.length;i++){
            if(st.contains(i))ls.add(temp[i]);
        }
        return ls;
    }
}

// Gap 
// 1 2 3 4 5
