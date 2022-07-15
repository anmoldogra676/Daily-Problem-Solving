class Solution {
    int count=0;
    public int maxAreaOfIsland(int[][] grid) 
    {
     // dfs 
        int ans=0;
        for(int i=0;i<grid.length ;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=0;
                    dfs(grid, i, j);
                    ans=Math.max(ans, count);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][]arr, int r,int c){
        if(r<0 || r>=arr.length || c<0 || c>=arr[0].length ||arr[r][c]==0)return;
        
        count++;
        arr[r][c]=0;
        dfs(arr, r+1, c);
        dfs(arr, r, c+1);
        dfs(arr, r-1, c);
        dfs(arr, r, c-1);
        
    }
}