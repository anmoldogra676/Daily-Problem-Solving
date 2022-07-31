class Solution {
    public int maximumSwap(int ar) {
        String tem = Integer.toString(ar);
        int[] arr = new int[tem.length()];
        for (int i = 0; i < tem.length(); i++)
        {
            arr[i] = tem.charAt(i) - '0';
        }

        int []temp = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1){
                temp[i]= Integer.MIN_VALUE;
            }else if(i==arr.length-2){
                temp[i]=i+1;
            }else{
                // aur koi bhi case 

                if(arr[i+1]>arr[temp[i+1]]){
                    temp[i]=i+1;
                }else{
                   temp[i]=temp[i+1]; 
                }
                         
            }
        }
        // temp array is created now task is to swap
                        // 2 7 3  6
                        // 1 3 3 -1
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[temp[i]]){
                int val1 = arr[i];
                int val2 = arr[temp[i]];
                int temp1= val1;
                arr[i]= val2;
                arr[temp[i]]=temp1;
                break;
            }
        }
        int res=0;
          for(int i=0;i<arr.length;i++) {
                  res=res*10+arr[i];
          }
        return res;
    }
}