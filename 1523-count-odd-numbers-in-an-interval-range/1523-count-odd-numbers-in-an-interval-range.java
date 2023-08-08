class Solution {
    public int countOdds(int low, int high) {
        if(high == low) return high % 2;
        high = high % 2 == 0 ? high - 1 : high;
        return (high - low) / 2 + 1;
    }
}