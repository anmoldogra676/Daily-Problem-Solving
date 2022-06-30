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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

/**
Main Logic --> 3 cases root wala A.P --> agr dfs tree m 1 se jyada baar call lgi means more than 1 coponenet
 agr leaf hai toh ignore and non root hai--> agr koi bhi aisa child hua jo uper kisi ko jaanta ho toh woh
 hmare pass A.P. hai.
 low , dis time ki help se--> discovery--> means jb phli baar visit kiya 
 low--> uski dfs tree m minimum kis bnde tk ki reach hai-->lowest discovery time that it can reach 
 with a alternate path.
 if par toh ignore -->
 if visited --> update low time with that discovery time
 if not visited then call -> after return to it update the times and check for articulation point
 ki --> non root ho aur low[nbr]>=dis[src] --> low means lowest discovery time kisko jaanta hai agr woh 
 bada hai hmare discovery se toh means yhi ek path hia ..so add in result 
 **/
class Solution
{
    public int[] articulationPoints(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        int []dis = new int[n];
        int []low = new int[n];
        boolean []vis= new boolean[n];
        boolean []aps= new boolean[n];
        time=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(dis,low, vis, aps, adj, i, -1);
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(aps[i]==true)c++;
        }
        if(c==0)return new int[]{-1};
        int []ans = new int[c];
        c=0;
        for(int i=0;i<n;i++){
            if(aps[i]==true)ans[c++]=i;
        }
        return ans;
    }
    int time;
    public void dfs(int []dis, int []low, boolean[]vis , boolean[]aps,ArrayList<ArrayList<Integer>> adj, int src, int par){
        
        vis[src]=true;
        dis[src]=time;
        low[src]=time;
        time++;
        int count=0;
        for(int nbr: adj.get(src)){
            if(par==nbr)continue;
            else if(vis[nbr]){
                // visisted neighbour
                low[src]=Math.min(low[src], dis[nbr]); // backEdge hai toh 
                // koi aur rsta hai iske uper jaane ka toh uske discovery se replace kr do
            }else{
                dfs(dis,low,vis,aps,adj,nbr,src);
                low[src]=Math.min(low[src], low[nbr]);
                if(par!=-1 && low[nbr]>=dis[src])aps[src]=true;
                count++;
            }
        }
        
        
        if(par==-1 && count>=2)aps[src]=true;
        
        
    }
 
}