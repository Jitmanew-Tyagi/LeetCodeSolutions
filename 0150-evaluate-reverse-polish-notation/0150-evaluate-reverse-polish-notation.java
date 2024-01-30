class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+") || 
               str.equals("-") || 
               str.equals("*") || 
               str.equals("/")) st.push(evaluate(st.pop(), st.pop(), str));
            else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
    
    public int evaluate(int b, int a, String op) {
        if(op.equals("+")) return a + b;
        if(op.equals("-")) return a - b;
        if(op.equals("*")) return a * b;
        return a / b;
    }
}