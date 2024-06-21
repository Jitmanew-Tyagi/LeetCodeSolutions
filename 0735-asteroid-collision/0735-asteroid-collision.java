class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroids) {
            if(ast > 0) st.push(ast);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -ast) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(ast);
                if(st.peek() == -ast) st.pop();
            }
        }
        
        int idx = st.size() - 1, ans[] = new int[st.size()];
        while(!st.isEmpty()) ans[idx --] = st.pop();
        return ans;
    }
}