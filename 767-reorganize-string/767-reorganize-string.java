class Solution {
     class pair{
        char ch;
        int val;
        pair(char ch, int val){
            this.ch =ch;
            this.val=val;
        }
        pair(){
            
        }
    }
    
   
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        int[] ch1 = new int[26];
        for(char ch2 : s.toCharArray()){
            ch1[ch2-'a']++;
        }
        PriorityQueue<pair>pq =new PriorityQueue<>((a,b)->{
            return b.val-a.val;
        });
        for(int i=0;i<26;i++){
            if(ch1[i]!=0){
                if(ch1[i]>(s.length()+1)/2)return "";
                pq.add(new pair( (char)('a'+i), ch1[i])); // character and kitni baar appear hua hai
            }
        }

        pair save=null;
        while(pq.size()>0){
            pair p =pq.poll();
            char ch = p.ch;
            int val = p.val;
            val--;
            ans.append(ch);
            if(save!=null && ch!=save.ch){
                pq.add(save);
            }
            if(ans.length()>0 && ans.charAt(ans.length()-1)==ch && val>0){
                pair pp = new pair(ch , val);
                save = pp;
            }else{
                save =null;
            }
        
            
        }
        // if(ans.length()!=s.length())return"";
        return ans.toString();
    }
}


// 1. Edge  case


//  aaabb -> a->3 b->2
     
//      1. hashmap--> (char, count no. of time char appears);
// 2. PrioryQueue ->



// a-->2. b->1
// ans=-->  ab
// if(s length ==0 || character does not match with last character of answer String)add into answer
// if(last character of my answer matches with character){
//    remove the 2nd most 
//    and add the first one and 2nd one also.
// }

    
 
