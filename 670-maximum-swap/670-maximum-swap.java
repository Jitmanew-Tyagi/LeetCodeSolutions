class Solution {
    public int maximumSwap(int num) {
        String str = num + "";
        int n = str.length(), arr[] = new int[10];
        Arrays.fill(arr, -1);
        for(int i = 0; i < n; i ++) arr[str.charAt(i) - '0'] = i;
        for(int i = 0; i < n; i ++) {
            for(int j = 9; j > str.charAt(i) - '0'; j --) {
                if(arr[j] > i) 
                    return Integer.parseInt(str.substring(0,i) + 
                           j + 
                           str.substring(i + 1, arr[j]) + 
                           str.charAt(i) + 
                           str.substring(arr[j] + 1));
            }
        }
        return num;
    }
}