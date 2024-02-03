class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < tickets.length; i ++) que.add(i);
        int time = 0;
        while(!que.isEmpty()) {
            int fp = que.remove();
            tickets[fp] --;
            time ++;
            if(fp == k && tickets[fp] == 0) return time;
            if(tickets[fp] > 0) que.add(fp);
        }
        return time;
    }
}