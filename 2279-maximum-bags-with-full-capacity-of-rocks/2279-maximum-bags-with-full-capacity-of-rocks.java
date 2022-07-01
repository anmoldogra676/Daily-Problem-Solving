class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int nn) {
        int []arr = new int[capacity.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Math.abs(capacity[i]-rocks[i]);
        }
        Arrays.sort(arr);
        int n= arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)ans++;
            else{
              if(nn-arr[i]>=0){
                  ans++;
                  nn-=arr[i];
              }else{
               return ans;   
              }
            }
        }
        return ans;
    }
}
