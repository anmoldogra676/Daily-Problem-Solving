class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {
        Arrays.sort(arr,(a,b)->{
            return b[1]-a[1];
        } );
        // unit k basis pe sort kr liye
        int ans=0;
        for(int i=0;i<arr.length ;i++){
            int no = arr[i][0];
            int unit = arr[i][1];
            if(truckSize -no >=0){
                ans+=(no*unit);
                truckSize-=no;
            }else{
              ans+=truckSize*unit;
                truckSize=0;
            }
         
             if(truckSize==0){
                return ans;
            }
        }
        return ans;
    }
}
