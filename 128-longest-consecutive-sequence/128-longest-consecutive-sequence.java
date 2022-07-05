class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==0)return 0;
        int ans=1;
        int c=1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]==arr[i+1])continue;
            if(arr[i]+1==arr[i+1]){
                c++;
            }else{
                c=1;
            }
            ans=Math.max(ans, c);
        }
        return ans;
    }
}

// 1 2 3 4 100 200