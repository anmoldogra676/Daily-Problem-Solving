// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] arr, int N) {
        // code here
        if(arr[0]==0)return 0;
        int 
        return helper(arr, 0);
    }
    public static int helper(int []arr, int i){
        if(i==arr.length-1)return 1;
        for(int j=1;j<=arr[i] &&i+j<arr.length ;j++ ){
            int f1 =helper(arr, i+j);
            if(f1==1)return 1;
            
        }
        return 0;
    } 
};