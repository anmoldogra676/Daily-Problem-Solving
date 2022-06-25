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
}