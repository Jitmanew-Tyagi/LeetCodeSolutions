class Solution {
    public int fib(int n) {
        return rec(n);
    }
    
    public int rec(int n) {
        if(n <= 1) return n;
        return rec(n - 1) + rec(n - 2);
    }
}