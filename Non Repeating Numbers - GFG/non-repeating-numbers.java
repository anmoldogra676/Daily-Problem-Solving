//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xor=0;
        for(int a: nums)xor^=a;
        int rsb = xor & -xor;
        int x=0;
         int y=0;
        for(int a: nums){
            if((int)(a&rsb)==0){
                x=x^a; 
            }else{
                y=y^a;
            }
            
        }
        int []ans = new int[2];
                   ans[0]=x;
           ans[1]=y;
       if(x>y){
           ans[0]=y;
           ans[1]=x;
       }
       return ans;
    }
}