//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
			//code
			
		//taking input using class Scanner
		Scanner scan = new Scanner(System.in);
		
		//taking total number of testcases
		int t = scan.nextInt();
		while(t>0)
		{
		    //taking total count of elements
		    int n = scan.nextInt() ;
		    
		    //Declaring and Initializing an array of size n
		    int arr[] = new int[n];
		    
		    //adding elements to the array
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		    
		     //calling the method findSum
		     //and print "YES" or "NO" based on the result
		     System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
		}
	}
	
	
}
// } Driver Code Ends


class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
             int ans=0;
       HashMap<Integer,Integer>hs= new HashMap<>();
       hs.put(0,1);
       int sum=0;
       for(int i=0;i<n;i++){
           int val=arr[i];
           sum+=val;
           if(sum==0){
               ans=Math.max(ans,i+1);
               return true;
           }
           if(hs.containsKey(sum)){
               ans=Math.max(ans,i-hs.get(sum) );
               return true;
           }
           if(hs.containsKey(sum)==false)
           hs.put(sum,i);
           
       }
    return false;
    }
}