class Solution {
    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for(String str : words) {
            Node temp = root;
            for(char c : str.toCharArray()) {
                if(temp.alp[c - 'a'] != null) temp.alp[c - 'a'].n ++;
                else temp.alp[c - 'a'] = new Node(1);
                temp = temp.alp[c - 'a'];
            }
        }
        int idx = 0, n = words.length, ans[] = new int[n];
        for(String str : words) {
            int power = 0;
            Node temp = root;
            for(char c : str.toCharArray()) {
                power += temp.alp[c- 'a'].n;
                temp = temp.alp[c - 'a'];
            }
            ans[idx ++] = power;
        }
        return ans;
    }
    
    class Node {
        Node[] alp = new Node[26];
        int n;
        Node() {}
        Node(int n){this.n = n;}
        Node(Node[] alp, int n){this.alp = alp; this.n = n;}
    }
}