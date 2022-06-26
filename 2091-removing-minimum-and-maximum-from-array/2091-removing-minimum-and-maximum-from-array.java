class Solution {
    public int minimumDeletions(int[] arr) {
        if(arr.length==1)return 1;
        int n= arr.length;
        int min=0,max=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[max])max=i;
            if(arr[i]<arr[min])min=i;
        }
        if(min>max){
            int temp=max;
            max=min;
            min=temp;
            
        }
   
        int val1 = arr.length-min;
        int val2 = min+1 +(arr.length-max);
        return Math.min(max+1, Math.min(val1 , val2));
        
    }
}