//{ Driver Code Starts
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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
     class pair{
        int sr;
        int sc;
        pair(int sr,int sc){
            this.sr=sr;
            this.sc=sc;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
         int [][]dir ={{0,-1},{-1,0},{0,1},{1,0}};
        LinkedList<pair>ls = new LinkedList<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              
                {
                    if(grid[i][j]==2){
                       ls.add(new pair(i,j));
                     }else if(grid[i][j]==1){
                         count++;
                     }
                
                }
                
            }
        }
        if(count==0)return 0;
        int level=0;
        while(ls.size()>0){
            int s=ls.size();
            while(s-->0){
                pair p= ls.removeFirst();
                //now time to check neighbour
                for(int []a:dir){
                   int nr = p.sr+a[0];
                   int nc = p.sc+a[1];
                   if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 ){
                       ls.add(new pair(nr,nc));
                       grid[nr][nc]=2;
                    //   System.out.println(level +" "+nr +" "+ nc + " "+count);
                       count--;
                   }
                }
                
            }
            level++;
            if(count==0)return level;
        }
        if(count==0)return level;
        return -1;
             
    }
}