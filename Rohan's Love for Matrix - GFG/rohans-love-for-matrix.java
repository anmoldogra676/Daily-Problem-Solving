// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.firstElement(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        int []arr = new int[n+1];
        Arrays.fill(arr, -1);
        return fib(n, arr);
        
    }
    public static  int fib(int n, int []arr){
        int m= (int)(1e9+7);
        if(n==0 || n==1)return n;
        if(arr[n]!=-1)return arr[n];
        return arr[n]=((fib(n-1, arr)%m)+(fib(n-2, arr)%m))%m;
    }
}
// 0 1 2 3