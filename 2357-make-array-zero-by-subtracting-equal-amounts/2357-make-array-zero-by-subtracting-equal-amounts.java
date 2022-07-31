class Solution {
    public int minimumOperations(int[] arr) {
        int ans=0;
        int m=0;
                            Arrays.sort(arr);
        while(m<arr.length){
             while(m<arr.length && arr[m]==0)m++;
             if(m>=arr.length)break;
            //    for(int i=0;i<arr.length ;i++){
            //     System.out.print(arr[i]+" ");
            // }
            int val= arr[m];
            // System.out.println(" ,"+ vk+" ");
           
            for(int i=m;i<arr.length;i++){
                // System.out.println(i + " ," +arr[i]+" , "+ arr[m]);
                   arr[i]= arr[i]-val; 
                
            }
         
            m++;
            ans++;

            
        }
        return ans;
    }
}