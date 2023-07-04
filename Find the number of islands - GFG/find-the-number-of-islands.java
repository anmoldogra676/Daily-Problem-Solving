//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] arr) {
        // Code here
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='1'){
                    dfs(arr, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][]arr, int i , int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]=='0')return;
        arr[i][j]='0';
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
        dfs(arr,i,j-1);
        dfs(arr,i,j+1);
        dfs(arr,i-1,j-1);
        dfs(arr,i+1,j+1);
        dfs(arr,i+1,j-1);
        dfs(arr,i-1,j+1);
    }
}