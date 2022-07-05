class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==0)return 0;
        int ans=1;
        HashSet<Integer>hs = new HashSet<>();
        for(int a: arr)hs.add(a); // added all the elements
        for(int a: arr){
            if(hs.contains(a-1)==false){
                // starting point
                int cv=a;
                int c=1;
                while(hs.contains(cv+1)){
                    c++;
                    cv=cv+1;
                }
                ans=Math.max(ans, c);
            }
        }

        return ans;
    }
}



