class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length, cprod = 1, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            cprod *= arr[i];
            max = Math.max(max, cprod);
            if(cprod == 0) cprod = 1;
        }
        cprod = 1;
        for(int i = n - 1; i >= 0; i --) {
            cprod *= arr[i];
            max = Math.max(max, cprod);
            if(cprod == 0) cprod = 1;
        }
        return max;
    }
}