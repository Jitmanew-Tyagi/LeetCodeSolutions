class Solution {
    public String pushDominoes(String dominoes) {
        char[] str = dominoes.toCharArray();
        int n = str.length;
        Queue<Pair> que = new LinkedList<>();
        for(int i = 0; i < n ; i++) 
            if(str[i] != '.') que.add(new Pair(i, str[i]));
        
        while(!que.isEmpty()) {
            Pair rem = que.remove();
            if(rem.c == 'L'){
                if(rem.i - 1 >= 0 && str[rem.i - 1] == '.') {
                    int nidx = rem.i - 1;
                    str[nidx] = 'L';
                    que.add(new Pair(nidx, 'L'));
                }
            } else {
                if(rem.i + 1 < n && str[rem.i + 1] == '.') {
                    if(rem.i + 2 < n && str[rem.i + 2] == 'L') que.remove();
                    else {
                        int nidx = rem.i + 1;
                        str[nidx] = 'R';
                        que.add(new Pair(nidx, 'R'));
                    }
                }
            }
        }
        return new String(str);
    }
    
    class Pair {
        int i;
        char c;
        Pair(int i, char c) {
            this.i = i;
            this.c = c;
        }
    }
}