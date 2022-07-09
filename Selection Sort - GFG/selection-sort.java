// { Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}
// } Driver Code Ends


class Solution
{
// 	int  select(int arr[], int i)
// 	{
//         // code here such that selectionSort() sorts arr[]
// 	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    // Selection Sort selects the min element 
	    // and replace that with 1st one and goes on 
	    for(int i=0 ;i<n;i++){
	        int minIndex =i;
	        for(int j=i+1 ;j<n;j++){
	            if(arr[j]<arr[minIndex])minIndex =j;
	        }
	        swap(arr, minIndex, i);
	    }
	}
	public void swap(int[]arr, int i, int j){
	    int temp=arr[i];
	    arr[i]=arr[j];
	    arr[j]=temp;
	}
}