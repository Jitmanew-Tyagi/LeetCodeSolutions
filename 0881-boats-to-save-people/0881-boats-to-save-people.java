class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length, ans = 0, l = 0, r = n - 1;
        Arrays.sort(people);
        while(l <= r) {
            ans ++;
            if(people[l] + people[r] <= limit) 
                l++;
            r--;
        }
        System.gc();
        return ans;
    }
}