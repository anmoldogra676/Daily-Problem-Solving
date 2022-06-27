class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(char ch : n.toCharArray()){
            max=Math.max(ch-'0',max);
        }
        return max;
    }
}

