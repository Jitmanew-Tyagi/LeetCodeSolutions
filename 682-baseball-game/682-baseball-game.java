class Solution {
    public int calPoints(String[] ops) {
        List<Integer> ans = new ArrayList<>();
        for(String str : ops) {
            if(str.equals("C")) ans.remove(ans.size() - 1);
            else if(str.equals("D")) {
                int x = ans.get(ans.size() - 1);
                ans.add(2 * x);
            } else if(str.equals("+")) {
                int x = ans.get(ans.size() - 1), y = ans.get(ans.size() - 2);
                ans.add(x + y);
            } else ans.add(Integer.parseInt(str));
        }
        int sum = 0;
        for(int i : ans) sum += i;
        return sum;
    }
}