class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length ,n = matrix[0].length;
        int len = m*n;
        int [] arr = new int[len];
        int var =0;
        for(int i=0; i<m ; i++){
            for(int j=0;j<n;j++){
                arr[var++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        for(int i=0 ;i <arr.length ;i++){
            if(k==i+1){
                return arr[i];
            }
        }
        return -1;
    }
}