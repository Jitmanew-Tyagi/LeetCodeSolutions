class Solution {
    public long subArrayRanges(int[] arr) {
        long sum = 0, n = arr.length;
        for(int s = 0; s < n; s ++) {
            int min = arr[s], max = arr[s];
            for(int e = s; e < n; e ++) {
                if(arr[e] > max) max = arr[e];
                else if(arr[e] < min) min = arr[e];
                sum += max - min;
            }
        }
        return sum;
    }
}