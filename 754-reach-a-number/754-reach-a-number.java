class Solution {
    public int reachNumber(int target) {
        int ans =0;
        target = Math.abs(target);
        while(true){
            int range = ans*(ans+1)/2;
            if(range>=target && range%2==target%2 )break;
            ans++;
        }
        return ans;
    }
}