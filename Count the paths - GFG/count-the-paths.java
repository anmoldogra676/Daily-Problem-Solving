// { Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        ArrayList<Integer>[]arr = new ArrayList[n];
        for(int i=0;i<arr.length;i++){
            arr[i] =new ArrayList<>();
        }
        for(int[]a:edges){
            arr[a[0]].add(a[1]);
        }
        boolean[]vis = new boolean[n];
        vis[s]=true;
        return dfs(arr, s, d,vis);
        
        
    }
    public int dfs( ArrayList<Integer>[]arr, int src, int dest, boolean[]vis){
        if(src==dest){
            return 1;
        }
        
        int ans=0;
        for(int nbr : arr[src]){
            if(vis[nbr]==false){
                vis[nbr]=true;
            ans+=dfs(arr,nbr, dest, vis);
                vis[nbr]=false;
            }
        }
        return ans;
    }
}
