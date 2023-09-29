class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.size(); i ++) 
            if(countSetBits(i) == k) 
                ans += nums.get(i);
        return ans;       
    }
    
    public int countSetBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i ++) if(isSet(n, i)) ans ++;
        return ans;
    }
    
    public boolean isSet(int n, int k) {
        return ((n & (1 << k)) > 0);
    }
}