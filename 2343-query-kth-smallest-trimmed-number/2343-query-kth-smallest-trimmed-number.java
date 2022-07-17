class Solution {
    class pair{
        String str;
        int v;
        pair(String str, int v){
            this.str = str;
            this.v=v;
        }
        pair(){
            
        }
        
    }
    public int[] smallestTrimmedNumbers(String[] arr, int[][] q) {
        int []ans = new int[q.length];
        for(int r=0;r<q.length;r++){
            int[]a = q[r];
             
            pair []pq = new pair[arr.length];
            for(int i=0;i<arr.length ;i++){
                pq[i] = new pair(arr[i].substring(arr[i].length()-a[1])  ,i);
            }
            Arrays.sort(pq,(a1,b1)->{
         
                if(a1.str.equals(b1.str)) return Integer.compare(Integer.valueOf(a1.v), Integer.valueOf(b1.v));
                
                String first = a1.str;
                String second = b1.str;
                
                for(int i = 0; i < first.length(); i += 1) {
                    int firstDigit = first.charAt(i) - '0';
                    int secondDigit = second.charAt(i) - '0';
                    if(firstDigit < secondDigit) return -1;
                    else if(firstDigit > secondDigit) return 1;
                }
                
                return 0;
                
            });
            ans[r]= pq[a[0]-1].v;
           
            }
        return ans;
    }
}