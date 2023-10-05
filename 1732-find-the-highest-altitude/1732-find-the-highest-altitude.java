class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0, max = 0;
        for(int ele : gain) {
            alt += ele;
            max = Math.max(alt, max);
        }
        return max;
    }
}