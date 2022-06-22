// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    
    
    /*
    Mother vertex -->start krke pure grpah ko traverse kr lein
    hm hr unvisited node ko dfs call --> aur agr nhi paunche toh uske paath 
    aur woh nhi ho skte so next unvisited ko mothervertex ka potential mark kr do
    
    aakhiri bnda jisse hm call lgaye woh potential ansswer ho skta hai 
    phr us potential se call lgayenge toh apne aap answer aa jayega ki agr 
    kahin vis ka array false hua toh koi mother vertex nhi hai 
    */
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>graph)
    {
        // Code here
         boolean[]vis = new boolean[V];
  
        int mv=-1;
        for(int i=0;i<V;i++){
            if(vis[i]==false)
             {  dfs(i, graph, vis);
               mv=i;
             }
        }

        vis= new boolean[V];
        dfs(mv, graph, vis);
        for(int i=0;i<V;i++){
            if(!vis[i])return -1;
        }
      return mv;
    }
   
    public void dfs(int src,ArrayList<ArrayList<Integer>> graph, boolean[]vis ){
        
        vis[src]=true;
        for(int nbr : graph.get(src)){
            if(vis[nbr]==false){
                dfs(nbr, graph, vis);
            }
        }
        
    }
}