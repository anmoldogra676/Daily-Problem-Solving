class Solution {
    public int reversePairs(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
     static int helper(int[]arr, int l, int r){
            
            int ans=0;
         if(l<r){
            int mid = (l+r)/2;
            ans+= helper(arr,l, mid );
            ans+= helper(arr, mid+1, r);
            ans+= merge(arr, l, mid, r);
                }
            return ans;
    }
    public static int merge(int []arr, int l, int mid,int r){
       
        int inv_count=0;
         int i=l;
        int j=mid+1;
        while(i<=mid && j<=r){
            
            if((long)(arr[i]) >(long)(2* (long)arr[j])){
                inv_count=inv_count+ (mid-i+1);
                j++;
            }
            else{
             i++;
            }
        }
        
         int m=l;
         int n=mid+1;
         int k=0;
        int []temp =new int[r-l+1];
        while(m<=mid && n<=r){
            if(arr[m]<=arr[n]){
                temp[k]=arr[m];
                m++;
                k++;
            }else{
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
        for(int z=l;z<=r;z++){
            arr[z]=temp[z-l];
         }
    
        return inv_count;
    }
}