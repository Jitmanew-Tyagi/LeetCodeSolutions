class Solution {
    public String reorganizeString(String s) {
        int[] fm = new int[26];
        for(char c : s.toCharArray()) fm[c -'a'] += 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i ++) if(fm[i] > 0) pq.add(new int[]{i, fm[i]});
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] out = pq.poll();
            char c = (char)(out[0] + 'a');
            if(sb.isEmpty() || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                if(-- out[1] > 0) pq.add(out);
            } else {
                if(pq.isEmpty()) return "";
                int[] sout = pq.poll();
                char sc = (char)(sout[0] + 'a');
                sb.append(sc);
                if(-- sout[1] > 0) pq.add(sout);
                pq.add(out);
            }
        }
        System.gc();
        return sb.toString();
    }
}