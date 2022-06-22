class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[]arr = new int[26];
        int n=0;
        for(char ch : order.toCharArray()){
            arr[ch-'a']=n;
                n++;
        }
        // Index maintain ho gya ki kiska order kya hai 
        for(int i=0;i<words.length-1 ;i++){
            if(!order(words[i], words[i+1], arr))return false;
        }
        return true;
    }
    public boolean order(String s1, String s2, int[] arr){
        for(int i=0; i<Math.min(s1.length() , s2.length());i++){
            if(arr[s1.charAt(i)-'a'] == arr[s2.charAt(i)-'a'] )continue;
            if(arr[s1.charAt(i)-'a'] >arr[s2.charAt(i)-'a'] )return false;
            if(arr[s1.charAt(i)-'a'] < arr[s2.charAt(i)-'a'] ) return true;
        }
        return s1.length()<=s2.length();
    }
}