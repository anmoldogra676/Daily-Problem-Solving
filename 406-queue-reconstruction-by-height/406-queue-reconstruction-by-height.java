// Greedy approach--> agr same height hai -> to small k wala phle aayega 
// otherwise longest height ko phle kr do kyunki unhe matter nhi krta agr chote wale beech m aa jaye toh 
// sort hone k baad --> k ko idx bna k krte rho add
class Solution {
    public int[][] reconstructQueue(int[][] arr) {
        Arrays.sort(arr, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
            List<int[]>ls = new LinkedList<>();
        for(int []a: arr){
            ls.add(a[1], a);
        }
        return ls.toArray(new int[ls.size()][2]);
    }
}
