class Solution {
    public int regionsBySlashes(String[] grid) {
       int n= grid.length;
        int dots = n+1;
        parent = new int[dots*dots]; 
        rank = new int[dots*dots]; 
        Arrays.fill(rank, 1);
        for(int i=0;i<dots*dots;i++)parent[i]=i;
        // connect boundary and mark the region int 1
        for(int i=0;i<dots;i++){
            for(int j=0;j<dots;j++){
                if(i==0 || j==0 || i==dots-1 || j==dots-1){
                    // union kr do 
                    int cellNum = i*dots+j;
                    // System.out.println(cellNum);
                    int par =find(cellNum);
                    int p2 = find(0);
                    union( par, p2);
                }
            }
        }
 /*       
        . . .
        . . .  --> connect outer boundary and make it as region 1. now based upon char make other region
        . . .
 */ 
        count=1;
        for(int i=0;i<grid.length;i++){
            char []ch = grid[i].toCharArray();
            for(int j=0;j<ch.length ;j++){
                
                if(ch[j]=='/'){
                    int c1 = i*dots+(j+1);
                    int c2 = (i+1)*dots +j;
                    int p1 = find(c1);
                    int p2 = find(c2);
                    if(p1!=p2)
                     union(p1, p2);
                    else {
                        count++;
                    }
                }else if(ch[j]=='\\'){
                    int c1 = i*dots+(j);
                    int c2 = (i+1)*dots +(j+1);
                    int p1 = find(c1);
                    int p2 = find(c2);
                    if(p1!=p2)
                     union(p1, p2);
                    else {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    int count;
    int [] parent;
    int [] rank;
    public void union(int i, int j){
        if(rank[i]>rank[j])parent[j]=i;
        else if(rank[i]<rank[j])parent[i]=j;
        else{
            parent[j]=i;
            rank[i]++;
        }
    } // union by Rank
    public int find(int j){
        if(j==parent[j])return j;
        return parent[j]=find(parent[j]);
    }
    
}

//-> DSU (Disjoint set union) -> Technique 
    

        