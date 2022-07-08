// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int arr[], int n) {
        
        // Your code here
        int res1 = maxSum(arr);
        if(res1<0)return res1;
        int sum=0;
        for(int i=0;i<arr.length ;i++){
            int a= arr[i];
            sum+=a;
            arr[i]=arr[i]*-1;
        }
        int val2 = maxSum(arr);
        return Math.max(res1, sum+val2);
        
        
      
    }
    public static int maxSum(int []arr){
        int res=arr[0];
        int sum_ending =arr[0];
        for(int i=1;i<arr.length ;i++){
            sum_ending = Math.max(sum_ending+arr[i],arr[i]);
            res=Math.max(res, sum_ending);
        }
        return res;
    }

}
// arr:  
// --> KADANE ALGO ( Max subarray sum) -O(n) Time
// {8,-8,9,-9,10,-11,12}

// ---> no circular  -2 4 6 8 -4
// --> circular region --> 

// 2 -4 2 -8 4 --> what kind of elements are there in middle -->min sum subarry
// -10
// sum of array --> -4 + 10 -->6 

