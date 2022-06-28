// DSU BASED QUESTION

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        rank = new int[n];
        parent= new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] a: edges){
            int srL = find(a[0]-1);
            int nbL = find(a[1]-1);
            if(srL!=nbL){
                union(srL, nbL);
            }else{
                return new int[]{a[0],a[1]}; // check for cycle
            }
        }
        return null;
        
    }
    int [] parent;
    int [] rank;
    public void union(int i, int j){
        if(rank[i]>rank[j])parent[j]=i;
        else if(rank[i]<rank[j])parent[i]=j;
        else{
            parent[i]=j;
            rank[j]++;
        }
    } // union by Rank
    public int find(int j){
        if(j==parent[j])return j;
        return parent[j]=find(parent[j]);
    }
}