class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroids) {
            if(ast > 0) st.push(ast);
            else {
                int mag = -ast;
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < mag) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(ast);
                else if(st.peek() == mag) st.pop(); 
            }
        }
        int n = st.size(), idx = 0;
        int[] ans = new int[n];
        for(int ast : st) ans[idx ++] = ast;
        return ans;
    }
}