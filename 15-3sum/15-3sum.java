class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        // -4 -1 -1 0 1 2 
        for(int i=0 ;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1])continue;
            int j=i+1;
            int k= arr.length-1;
            int sum= -1*arr[i];
            while(j<k){
                int val = arr[j]+arr[k];
                // System.out.println(i+ " " +j+ " "+ k +" "+arr[j]+" "+arr[k]);
                if(val==sum){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(arr[i]);
                    ls.add(arr[j]);
                    ls.add(arr[k]);
                    ans.add(ls);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1])j++;
                    while(k>j && arr[k]==arr[k+1])k--;
                }else if(val>sum){
                    k--;
                }else{
                    j++;
                }
            }   
        }
        return ans;
    }
}