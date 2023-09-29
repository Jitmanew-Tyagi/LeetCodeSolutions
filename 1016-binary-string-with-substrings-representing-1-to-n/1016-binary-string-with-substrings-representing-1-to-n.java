class Solution {
    public boolean queryString(String s, int n) {
        int k = n;
        Queue<String> que = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        que.add("1");
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                String out = que.remove();
                if(!s.contains(out)) return false;
                if(--k == 0) return true;
                que.add(out + "0");
                que.add(out + "1");
            }
        }
        return true;
    }
}