class Solution {
    public int compress(char[] chars) {
        int i = 0, count = 1;
        StringBuilder sb = new StringBuilder();
        while(i < chars.length) {
            if(i != chars.length - 1 && chars[i] == chars[i + 1]) count ++;
            else {
                sb.append(chars[i]).append(count == 1 ? "" : count);
                count = 1;
            }
            i ++;
        }
        int idx = 0;
        for(char c : sb.toString().toCharArray()) chars[idx ++] = c;
        return sb.length();
    }
}