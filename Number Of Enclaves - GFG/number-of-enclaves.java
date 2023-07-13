//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    class pair{
        int sr;
        int sc;
        pair(int sr,int sc){
            this.sr=sr;
            this.sc=sc;
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int [][]dir ={{0,-1},{-1,0},{0,1},{1,0}};
        LinkedList<pair>ls = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 ||i==grid.length-1 || j==grid[0].length-1)
                {
                    if(grid[i][j]==1){
                       ls.add(new pair(i,j));
                     }
                
                }
                
            }
        }
        
        
        while(ls.size()>0){
            int s=ls.size();
            while(s-->0){
                pair p= ls.removeFirst();
                grid[p.sr][p.sc]=0; // visited
                //now time to check neighbour
                for(int []a:dir){
                   int nr = p.sr+a[0];
                   int nc = p.sc+a[1];
                   if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 ){
                       ls.add(new pair(nr,nc));
                   }
                }
                
            }
        }
        
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)ans++;
            }
            
        }
        return ans;
    }
}