class Solution {
      public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character, Integer>hs =new HashMap<>();
        for(char ch: s.toCharArray()){
            hs.put(ch, hs.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            if(hs.containsKey(ch)==false )return false;
            else{
                hs.put(ch , hs.get(ch)-1);
                if(hs.get(ch)==0)hs.remove(ch);
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>>ans = new ArrayList<>();
       if(arr.length==0)return ans;
        boolean[]vis =new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(vis[i]==false){
                vis[i]=true;
                 List<String>ls = new ArrayList<>();
                ls.add(arr[i]);
                for(int j=i+1;j<arr.length;j++){
                   if(isAnagram(arr[i], arr[j])){
                       vis[j]=true;
                       ls.add(arr[j]);
                   }
                }
                ans.add(ls);
            }
            
        }
        return ans;
        
    }
}