class Solution {
    public boolean isPossible(int[] target) {
        
        long sum=0;
        int max=0;
        for(int i=0; i<target.length;i++){
            sum+=target[i];
            if(target[i]>target[max])max=i;
        }
        
        // max value ka index hai && sum hia 
        long val = sum-target[max];
        if(target[max]==1 || val==1)return true;
        if(val>target[max] || val==0 || target[max]%val==0)return false;
        target[max]%=val;
        System.out.println(sum);
        return isPossible(target);
        
        
    }
}

// class Solution {
//     public boolean isPossible(int[] target) {
//         long sum =0;
//         int max=0;
        
//         for(int i=0;i<target.length;i++){
//             sum += target[i];
//             if(target[max]<target[i]){
//                 max = i;
//             }
//         }
        
        
//         long diff = sum - target[max];
        
//         if(target[max] == 1 || diff == 1) return true;

//         if(diff>target[max] || diff == 0 || target[max]%diff==0) return false;
        
//         target[max] %= diff;
        
//         return isPossible(target);
//     }
// }