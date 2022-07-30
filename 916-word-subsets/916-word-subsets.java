class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>ans = new ArrayList<>();
        int []bfreq = new int[26];
        for(String s : words2){
            int []temp = count(s);
            for(int i=0;i<26;i++)
            bfreq[i]=Math.max(bfreq[i], temp[i]);
        }
        // max frequency of bfreq is present 
        for(String s : words1){
            int [] temp = count(s);
            boolean flag = false;
            for(int i=0 ;i < 26 ;i++){
                if(temp[i]< bfreq[i]){
                    flag= true;
                    break;
                }
            }
            if(!flag)ans.add(s);
        }
        return ans;
        
    }
    public int[] count(String s){
        char [] arr = s.toCharArray();
        int []ans = new int[26];
        for(char ch : arr){
            ans[ch-'a']++;
        }
        return ans;
    }
}