//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends




//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    
    public static int countStudents(int []arr, int pages){
        // itne pages m want skte ki nh
        int p=1;
        int s=0;
        for(int i=0;i<arr.length ;i++){
            
            if(s+arr[i]<=pages){
                s+=arr[i];
            }else{
               p++;
               s=arr[i];
            }
            
            
        }
       return p;
 
    }
    
    public static int findPages(int[]arr,int n,int m)
    {
        //Your code here
        if(m>n)return -1;
        int lo=0;
        int sum=0;
        for(int a:arr){
            sum+=a;
            lo = Math.max(lo, a);
        }
        int ans=-1;
        int hi = sum;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            int val =countStudents(arr, mid );
            if(val<=m){
                ans=mid;
                hi=mid-1;
            }else{
             lo=mid+1;
            }
        }

        
        return ans;
        
    }
};