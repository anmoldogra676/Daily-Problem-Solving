class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer,Integer>hs = new HashMap<>();
        TreeSet<Integer>interval = new TreeSet<>();
        for(int[]a: trips){
            int num=a[0];
            int from= a[1];
            int to = a[2];
            hs.put(from, hs.getOrDefault(from, 0)+num);
            interval.add(from);
            interval.add(to);
            hs.put(to, hs.getOrDefault(to, 0)-num);
        }
    int sum=0;
    for(int a : interval){
        sum+=hs.get(a);
        if(capacity< sum)return false;
    }
    return true;
}
}
// 1 3  5  7
// 2 3 -2 -3