class Solution {
    public int consecutiveNumbersSum(int n) {
        // logic --> let us take a starting point s and number k 
        // which will tell how many numbers will we take
        // intially start from k=1;
        // 1 = s+0;
        // 2 = s+1;
        // 3 = s+2;
        //
        // k = s+k-1
        // when we sum
        // n = ks + k*(k-1)/2;
        // ks = n-k*(k-1)/2;
        // k*(k-1)/2<n ---> 1st thing 
        int k=1;
        int res=0;
        int check = k *(k-1)/2;
        while(check<n){
            if( (n-check)%k==0)res++;
            k++;
            check = k*(k-1)/2;
        }
        return res;
    }
}