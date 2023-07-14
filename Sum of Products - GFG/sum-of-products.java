//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long pairAndSum(int N, long a[]) {
        // code here
       //convert decimal number into binayr and then solve the problem
       long[][]arr = new long[62][N];
       for(int i=0;i<N;i++){
           long val = a[i];
           for(int j=61;j>=0;j--){
               long mask = val>>j;
               if((long)(mask&1)==1){
                   arr[j][i]=1;
               }
           }
           
       }
       // constructed the array 
       long sum=0;
       
       for(int i=0;i<62;i++){
           // bit 1;
           int count=0;
           long ans=0;
           if(arr[i][0]==1)count++;
           
           for(int j=1;j<N;j++){
               if(arr[i][j]==1){
                   ans+= count*(int)(Math.pow(2,i));
                   count++;
               }
           }
           sum+=ans;
           
       }
       
       
       return sum;
    }
}