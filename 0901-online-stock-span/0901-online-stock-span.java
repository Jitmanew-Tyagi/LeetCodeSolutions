class StockSpanner {
    Stack<Pair> st = new Stack<>();
    int ans, i;
    public StockSpanner() {
        i = 0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().price <= price) st.pop();
        ans = st.isEmpty() ? i + 1 : i - st.peek().day;
        st.push(new Pair(i, price));
        i ++;
        return ans;
    }
    
    public class Pair{
        int day, price;
        Pair(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */