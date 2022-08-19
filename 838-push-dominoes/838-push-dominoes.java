// L R
// R R
// L L
// R L

class Solution {
    public String pushDominoes(String dominoes) {
        
        String ss = "L" + dominoes +"R";
        int pi = 0;
        char []arr = ss.toCharArray();
        for(int i=1; i<arr.length ;i++){
            char ch = arr[i];
            if(ch=='L'){
                if(arr[pi]=='R'){
                    // special case
                    int t1 = pi+1;
                    int t2 = i-1;
                    while(t1<t2){
                        arr[t1]='R';
                        arr[t2] ='L';
                        t1++;
                        t2--;
                    }
                    
                }else if(arr[pi]=='L'){
                     for(int j=pi ;j<=i ;j++)arr[j]='L';
                }
                pi=i;
            }else if(ch=='R'){
                if(arr[pi]=='R'){
                    // Start from pi upto current and add R
                    for(int j=pi ;j<=i ;j++)arr[j]='R';
                    
                }else if(arr[pi]=='L'){
                    // do nothing
                }
                pi=i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<arr.length-1;i++)sb.append(arr[i]);
        return sb.toString();
        
    }
}