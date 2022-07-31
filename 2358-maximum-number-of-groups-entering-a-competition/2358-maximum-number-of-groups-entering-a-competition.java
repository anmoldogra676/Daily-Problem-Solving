class Solution {
    public int maximumGroups(int[] grades) {
        // Sort kr lunga --> toh dono condition satisfy 
        // 1 , 2 ,3,4, aise so on group bnege 
        // so basically I can do Binary Search or I can manually check
        int n = grades.length;
        int sum=0;
        int i=0;
        while(sum<n){
            i++;
            sum = i*(i+1)/2;
            if(sum==n)return i;
        }
        return i-1;
    }
}