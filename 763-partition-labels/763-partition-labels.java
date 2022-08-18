class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer>hs = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hs.put(ch, i);
        }
        int max=-1;
        int len =0;
        List<Integer>ls = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);// character aa gya ek 
            len++;
            max =Math.max(max, hs.get(ch));
            if(max==i){
                ls.add(len);
                max=-1;
                len=0;
            }
        }
        return ls;
    }
}