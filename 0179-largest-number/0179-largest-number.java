class Solution {
    public String largestNumber(int[] arr) {
        bubbleSort(arr, arr.length);
        String ans = "";
        for(int i = arr.length - 1; i >= 0; i --) ans += arr[i];
        return arr[arr.length - 1] == 0 ? "0" : ans;
    }
    
    public void bubbleSort(int[] arr, int n) {
        for(int itr = 1; itr < n; itr ++) {
            for(int j = 0; j < n - itr; j ++) {
                String ab = arr[j] + "" + arr[j + 1];
                String ba = arr[j + 1] + "" + arr[j];
            
                if(ab.compareTo(ba) > 0) swap(arr, j, j + 1);
            }
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}