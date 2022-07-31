class Solution {
    public int maximumGroups(int[] grades) {
        return (int)((Math.sqrt(grades.length * 8 + 1) - 1)/2);
    }
}