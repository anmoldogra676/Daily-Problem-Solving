class Solution {
    public int maxArea(int h, int w, int[] hr, int[] vc) {
           Arrays.sort(hr);
           Arrays.sort(vc);
           int ans=0;
           long maxGap1=0;
           for(int i=1;i<hr.length;i++){
               maxGap1 = Math.max( (long) hr[i]-(long)hr[i-1], maxGap1);
           }
        
           long maxGap2 =0;
           for(int i=1;i<vc.length;i++){
               maxGap2 = Math.max( (long) vc[i]-(long)vc[i-1], maxGap2);
           }
           maxGap1 =Math.max(maxGap1, (long)h- (long)hr[hr.length-1]);
        
           maxGap1 =Math.max(maxGap1, (long)hr[0]-0);
        
           maxGap2 =Math.max(maxGap2, (long)w- (long)vc[vc.length-1]);
           maxGap2 =Math.max(maxGap2, (long)vc[0]-0);
           int m= (int)(1e9 +7);
          
           return (int)((maxGap1%m *maxGap2%m)%m );
    }
}