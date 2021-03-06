// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        if(sum==0)return true;
        boolean[][]dp = new boolean[n][sum+1];
        // return helper(arr, sum, n-1, dp);
        if(arr[0]<=sum)dp[0][arr[0]]=true;
        for(int i=0;i< n;i++ )dp[i][0]=true;
        for(int i=1;i<arr.length ;i++){
            for(int j=1;j<=sum;j++){
                boolean val1=dp[i-1][j];
                boolean val2=false;
                if(j-arr[i]>=0){
                    val2 =dp[i-1][j-arr[i]];
                }
                dp[i][j]= val1 || val2;
            }
        }
        
        
        
       return dp[n-1][sum];
 
    }
    public static  Boolean helper(int []arr, int sum, int idx, int [][]dp){
        if(sum==0)return true;
        if(idx==0)return arr[idx]==sum;
        if(dp[idx][sum]!=0){
            if(dp[idx][sum]==1)
            return true;
            return false;
        }
        Boolean notTaken = helper(arr, sum, idx-1,dp);
        Boolean taken = false;
        if(sum-arr[idx]>=0){
            taken = helper(arr, sum-arr[idx] ,idx-1,dp);
        }
        Boolean bb= taken||notTaken;
        dp[idx][sum]=bb==true?1:-1;
        return bb;
    }
}