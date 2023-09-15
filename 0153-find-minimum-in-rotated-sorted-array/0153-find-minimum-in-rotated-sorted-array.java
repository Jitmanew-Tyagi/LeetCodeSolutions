class Solution {
    public int findMin(int[] arr) {
        int s = 0, e = arr.length - 1;
        if(s == e || arr[s] < arr[e]) return arr[s];
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] > arr[mid + 1]) return arr[mid + 1];
            else if(arr[mid] < arr[mid - 1]) return arr[mid];
            if(arr[mid] > arr[e]) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}