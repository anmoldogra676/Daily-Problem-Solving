// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor=0;
        for(int a:arr)xor^=a;
        for(int i=1 ;i<=n ;i++)xor^=i;
        // xor --> 2 values
        // find rsb mask
        int rsbm = xor & -xor;
        // make 2 sets
        int x=0;
        int y=0;
        for(int a:arr){
            if((a &rsbm)==0){
                x=x^a;
                // System.out.println(x+" "+ a);
            }else{
                y=y^a;
            }
        }
        for(int a=1;a<=n;a++){
            if((a &rsbm)==0){
                x=x^a;
                // System.out.println(x+" "+ a);
            }else{
                y=y^a;
            }
        }
        for(int a: arr){
            if(a==x){
                return new int[]{x,y};
            }
            if(a==y){
                return new int[]{y,x};
                
            }
        }
        return new int[2];
    }
}