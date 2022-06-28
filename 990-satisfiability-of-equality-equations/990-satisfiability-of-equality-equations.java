class Solution {
    public boolean equationsPossible(String[] equations) {
        par = new char[26];
        rank= new int[26];
        Arrays.fill(rank, 0);
        for(int i=0;i<par.length ;i++){
            par[i]=(char)('a'+i);
        }
        for(String arr: equations){
            if(arr.charAt(1)=='='){
                char p1 = find(arr.charAt(0));
                char p2 = find(arr.charAt(3));
                if(p1!=p2)union(p1, p2);
            }
        }
         for(String arr: equations){
            if(arr.charAt(1)=='!'){
                char p1 = find(arr.charAt(0));
                char p2 = find(arr.charAt(3));
                if(p1==p2)return false;
            }
        }
        return true;
    }
    
    char[]par;
    int []rank;
    public void union(char ch1, char ch2){
        if(rank[ch1-'a']>rank[ch2-'a']){
            par[ch2-'a']=ch1;
        }else if(rank[ch1-'a']<rank[ch2-'a']){
            par[ch1-'a']= ch2;
        }else{
            par[ch1-'a']= ch2;
            rank[ch2-'a']++;
        }
    }
    public char find(char ch){
        if(par[ch-'a']==ch)return ch;
        return par[ch-'a'] = find(par[ch-'a']);
    }
    
    
}