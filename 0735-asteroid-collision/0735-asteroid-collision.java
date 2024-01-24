class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroids) {
            if(ast > 0) st.push(ast);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -ast) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(ast);
                else if(-ast == st.peek()) st.pop();
            }
        }
        int[] ans = new int[st.size()];
        int idx = 0;
        for(int ast : st) ans[idx ++] = ast;
        return ans;
    }
}