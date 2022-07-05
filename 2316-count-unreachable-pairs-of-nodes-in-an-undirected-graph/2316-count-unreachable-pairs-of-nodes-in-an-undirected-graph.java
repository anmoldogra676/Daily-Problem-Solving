class Solution {
    int[]par;
    int[]rank;
    public long countPairs(int n, int[][] edges) {
        par = new int [n];
        rank= new int[n];
        Arrays.fill(rank , 1);
        for(int i=0;i<par.length;i++)par[i]=i;
        // find component size
        for(int []a:edges){
            int u=a[0];
            int v=a[1];
            
            int p1 = find(u);
            int p2 = find(v);
            if(p1==p2)continue;
            par[p2]=p1;
            rank[p1]+=rank[p2];
            
            
        }
        // parent bna liye
        // now find unique leader
        HashSet<Integer>hs = new HashSet<>();
        for(int i=0;i<n;i++){
            if(par[i]==i)hs.add(i);
        }
       ArrayList<Integer>arr = new ArrayList<>();
        for(int a: hs){
            
            arr.add(rank[a]);
        }
        
        long ans=0;
        for(int a: arr){
            ans= ans + (long)(a)*(long)(n-a);
        }
        return ans/2;
        
        
        
    }
    
    public int find(int u){
        if(par[u]==u)return u;
        return par[u]=find(par[u]);
    }

}