// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return helper(arr, 0,arr.length-1);
        
    }
    static long helper(long[]arr, int l, int r){
        long ans=0;
        if(l<r){
            int mid = (l+(r-l)/2);
            ans+= helper(arr,l, mid );
            ans+= helper(arr, mid+1, r);
            ans+= merge(arr, l, mid, r);
        }
        return ans;
    }
    public static long merge(long []arr, int l, int mid,int r){
       
        long inv_count=0;
        int m=l;
        int n=mid+1;
        int k=0;
        long []temp =new long[r-l+1];
        while(m<=mid && n<=r){
            if(arr[m]<=arr[n]){
                temp[k]=arr[m];
                m++;
                k++;
            }else{
                inv_count+=mid-m+1;
                temp[k]=arr[n];
                k++;
                n++;
            }
        }
        while(m<=mid){
            temp[k]=arr[m];
                m++;
                k++;
        }
        while(n<=r){
             temp[k]=arr[n];
                k++;
                n++;
        }
        for(int i=l;i<=r;i++){
            arr[i]=temp[i-l];
            }
        return inv_count;
    }
}