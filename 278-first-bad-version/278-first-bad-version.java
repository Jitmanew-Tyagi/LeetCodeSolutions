/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans = n + 1, s = 0, e = n - 1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            boolean check = isBadVersion(mid);
            if(check) e = mid - 1;
            else s = mid + 1;
        }
        return e + 1;
    }
}