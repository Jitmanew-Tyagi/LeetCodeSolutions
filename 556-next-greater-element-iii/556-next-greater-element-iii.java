class Solution {
    public int nextGreaterElement(int n) {
        int len = (int) Math.log10(n) + 1, temp = n, idx = len - 1;
        int[] arr = new int[len];
        while(temp > 0) {
            arr[idx --] = temp % 10;
            temp /= 10;
        }
        idx = len - 2;
        while(true) {
            if(idx == -1) return -1;
            if(arr[idx] < arr[idx + 1]) break;
            idx --;
        }
        int jdx = len - 1;
        while(arr[jdx] <= arr[idx]) jdx --;
        swap(arr, jdx, idx);
        reverse(arr, idx + 1, len - 1);
        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i);
        long a = Long.parseLong(sb.toString());
        return a > Integer.MAX_VALUE ? -1 : (int) a;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void reverse(int[] arr, int s, int e) {
        while(s < e) 
            swap(arr, s ++, e --);
    }
}