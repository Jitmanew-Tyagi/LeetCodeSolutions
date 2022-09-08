class Solution {
    public int consecutiveNumbersSum(int n) {
        int count=  0;
        for(int k = 1; 2 * n > k * (k - 1); k ++) 
            if((n + (k * (k - 1) / 2)) % k == 0) count ++;
        return count;
    }
}