class Solution {
    public int[][] insert(int[][] arr, int[] nn) {
        ArrayList<int[]>ans = new ArrayList<>();
        int i=0;
        while(i<arr.length && arr[i][1]<nn[0]){
            // yeh starting k hain 
            ans.add(arr[i]);
            i++;
        }
        // ab kuch overlap wala mil gya hai 
        // m put kr dunga 
        int[]interval = nn;
        // ab mujhe aage se overlapping check krni hai 
        while(i<arr.length && arr[i][0]<=interval[1]){
            interval[0]=Math.min(interval[0],arr[i][0]);
            interval[1] =Math.max(interval[1],arr[i][1]);
            i++;
        }
        ans.add(interval);
        while(i<arr.length){
            ans.add(arr[i++]);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}