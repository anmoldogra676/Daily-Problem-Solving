class Solution {
    public String largestMerge(String word1, String word2) {
        return helper(word1 ,word2);
    }
    public String helper(String s1, String s2){
        if(s1.length()==0 && s2.length()==0)return "";
        if(s1.length()==0)return s2;
        if(s2.length()==0)return s1;
        if(s1.compareTo(s2)> 0){ // useful fxn result +ve means larger 
            return s1.substring(0,1)+ helper(s1.substring(1),s2);
        }else {
            return s2.substring(0,1)+ helper(s1,s2.substring(1));
        }
        

    }
}