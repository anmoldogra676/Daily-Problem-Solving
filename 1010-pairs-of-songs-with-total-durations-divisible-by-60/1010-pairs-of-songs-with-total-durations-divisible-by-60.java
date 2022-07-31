class Solution {
    public int numPairsDivisibleBy60(int[] arr) {
        HashMap<Integer, Integer>hs = new HashMap<>();
        long c=0;
        for(int i=0;i<arr.length ;i++){
            int val1 = arr[i]%60;
            hs.put(val1, hs.getOrDefault(val1,0)+1);
        }
        int []vala = new int[60];
        for(int a : hs.keySet()){
            if(a!=0 && vala[60-a]==1)continue;
            int t=a;
            int val= hs.get(a);
            if(a==0){
              c+= (long)val*(long)(val-1)/2;
              
            }else if( 2* a==60){
              c+= (long)val*(long)(val-1)/2;
            }else{
                int x = 60-a;
                if(hs.containsKey(x)==false)continue;
              int val1 = hs.get(x);
              c+=((long)val*(long)(val1));
              vala[a]=1;
             
            }
            // hs.remove(t);
        }

        return (int)c;
    }
}