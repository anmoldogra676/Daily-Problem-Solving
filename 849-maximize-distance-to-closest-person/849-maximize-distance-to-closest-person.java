class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans=1;
        ArrayList<Integer>arr = new ArrayList<>();
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1)arr.add(i);
        }
        if(arr.size()!=1){
           for(int m=0;m<arr.size()-1 ;m++){
               int val =(arr.get(m+1)+arr.get(m))/2;
               int val1 =val-arr.get(m) ;
               int val2 =arr.get(m+1)-val;
               ans=Math.max(ans, Math.min(val1, val2));
               // System.out.println(val+" ,"+ ans);
           }
        }
        // 0 4 5
        ans=Math.max(ans,arr.get(0)-0 );
        ans=Math.max(ans,seats.length-1-arr.get(arr.size()-1));
        return ans;
        
    }
}