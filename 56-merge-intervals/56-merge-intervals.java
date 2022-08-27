class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a,b)->{
            return a[0]-b[0];
        });
        // sort kr liya
        ArrayList<int[]>ans = new ArrayList<>();
        for(int[]a : arr){
            if(ans.size()==0){
                ans.add(a);// first time aa rha hai
            }else{
                int []temp = ans.get(ans.size()-1);// aakhiri bnda pda hoga
                if(temp[1]>=a[0]){ 
                    temp[1]=Math.max(temp[1],a[1]); // dono ke end ka  max lelo
                }else{
                    ans.add(a);// new interval hai add kr do 
                }
                
            }
        }
        // final list --> 
        int[][]res = new int[ans.size()][2];
        for(int i=0;i<res.length;i++){
            res[i]= ans.get(i);
        }
        return res;
    }
}