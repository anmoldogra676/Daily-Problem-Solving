class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b)->{
            return a.length()-b.length();
        });
        // for(String s: arr)System.out.print(s+" "); 
        // let us make dp which says length of longest possible word chain upto index i
        int[]dp = new int[arr.length];
        int max=1;
        Arrays.fill(dp, 1);
        for(int i=1; i<arr.length ;i++){
            for(int j=0; j<=i-1 ;j++){
                if(compare(arr[j],arr[i]) && dp[j]+1 >dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            // System.out.println(dp[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public boolean compare(String s1, String s2){
        // String s2 bdi ya barabarh hai
        int i=0;
        int j=0;
        if(s1.length()+1 != s2.length())return false;
        int count=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)== s2.charAt(j)){
                i++;
                j++;
            }else{
                if(count>=1)return false;
                count++;
                j++;
            }
        }
        return true;
        
    }
}

// ["xb","xbc","cxbc","pcxbc","pcxbcf"]
