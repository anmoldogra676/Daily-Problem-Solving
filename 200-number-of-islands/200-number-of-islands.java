class Solution {
    public int numIslands(char[][] grid) {
       int ans=0;
        for(int i=0;i<grid.length ;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void dfs(char [][]arr, int r,int c){
        if(r<0 || r>=arr.length || c<0 || c>=arr[0].length ||arr[r][c]=='0')return;
        
        arr[r][c]='0';
        dfs(arr, r+1, c);
        dfs(arr, r, c+1);
        dfs(arr, r-1, c);
        dfs(arr, r, c-1);
        
    }
}