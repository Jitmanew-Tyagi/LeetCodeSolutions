class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int popIdx = 0;
        for(int ele : pushed) {
            st.push(ele);
            while(!st.isEmpty() && st.peek() == popped[popIdx]) {
                st.pop();
                popIdx ++;
            }
        }
        while(!st.isEmpty() && st.peek() == popped[popIdx]) {
                st.pop();
                popIdx ++;
        }
        return st.isEmpty();
    }
}