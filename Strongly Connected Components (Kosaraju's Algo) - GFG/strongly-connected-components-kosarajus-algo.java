// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
     // postorder m add kr rhe hain stack m toh agr src-->dest component
     // toh src wala hmesa uper hoga destination wale se 
     // phr hmne edge ulti kr di --> toh src-> dest bnd kr diya rsta 
     // src se call lgai within component no change --> jitni call utna scc
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        // 1st step hai -->dfs call from every point
        boolean[]vis = new boolean[V];
        Stack<Integer>st = new Stack<>();
        //1st step complete
        for(int i=0;i<V;i++){
            if(vis[i]==false)
               dfs(i, V, adj, vis, st);
        }
        // 2nd step reverse edge
        ArrayList<ArrayList<Integer>> clone = new ArrayList<>();
        for(int i=0;i<V;i++){
            clone.  add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
             int src =i;
             for(int nbr:adj.get(i)){
                 clone.get(nbr).add(src);
             }
        }
    
        vis= new boolean[V];
        int ans=0;
        while(st.size()>0){
            int val= st.pop();
            if(!vis[val]){
                ans++;
                dfs1(val,V,clone, vis);
            }
        }
        return ans;
        
    }
     public void dfs(int src, int v,ArrayList<ArrayList<Integer>> graph, boolean[]vis, Stack<Integer>st ){
        
        if(vis[src])return;
        vis[src]=true;
        for(int nbr : graph.get(src)){
            if(vis[nbr]==false){
                dfs(nbr, v,graph, vis, st);
            }
        }
        st.push(src);
    }
    public void dfs1(int src, int v,ArrayList<ArrayList<Integer>> graph, boolean[]vis ){
        
        if(vis[src])return;
        vis[src]=true;
        for(int nbr : graph.get(src)){
            if(vis[nbr]==false){
                dfs1(nbr, v,graph, vis);
            }
        }
        
    }
}
