class Solution {
    public int minDeletions(String s) {
        int []arr =new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++; // 'a' 0 'z'25
        }
        HashSet<Integer>hs =new HashSet<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
         while(arr[i]>0 && hs.contains(arr[i]) ){
                ans++;
                --arr[i];
            }
            hs.add(arr[i]);// 2 1
        }
        return ans;
        
    }
}

