class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int nod = (int)Math.log10(x) + 1;
        int xd = x;
        int ans = 0;
        while (nod > 0) {
            int ld = xd % 10;
            ans = ans * 10 + ld;
            xd /= 10;
            nod --;
        }
        return (ans == x) ? true : false;
    
    }
}