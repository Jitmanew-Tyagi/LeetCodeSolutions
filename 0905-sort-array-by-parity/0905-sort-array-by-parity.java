class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int o = 0, e = arr.length - 1;
        while(o < e){
            while(o < e && arr[o] % 2 == 0) o ++;
            while(o < e && arr[e] % 2 != 0) e --;
            if(o < e) {
                int temp = arr[o];
                arr[o] = arr[e];
                arr[e] = temp;
            }
        }
        return arr;
    }
}