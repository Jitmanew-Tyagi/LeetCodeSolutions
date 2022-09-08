class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pop = 0;
        Stack<Integer> st = new Stack<>();
        for(int i : pushed) {
            st.push(i);
            while(!st.isEmpty() && popped[pop] == st.peek()) {
                st.pop();
                pop ++;
            }
        }
        while(!st.isEmpty() && st.peek() == popped[pop]) {
            st.pop();
            pop ++;
        }
        return st.isEmpty();
    }
}