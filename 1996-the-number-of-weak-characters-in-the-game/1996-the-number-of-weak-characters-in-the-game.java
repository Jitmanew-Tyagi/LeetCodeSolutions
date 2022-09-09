class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int noOfWE = 0, n = properties.length, max = properties[n - 1][1];
        for(int i = n - 2; i >= 0; i --) {
            int def = properties[i][1];
            if(def < max) noOfWE++;
            if(def > max) max = def;
        }
        return noOfWE;
    }
}