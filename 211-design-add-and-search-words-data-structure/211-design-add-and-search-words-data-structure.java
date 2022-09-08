class WordDictionary {
    
    public class Node {
        Node[] children;
        boolean isEnd;
        
        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        } 
        Node(boolean isEnd) {
            super();
            this.isEnd = true;
        }
        public boolean find(String word) {
            if(word.length() == 0) return isEnd;
            char tbf = word.charAt(0);
            if(tbf == '.') {
                for(Node child : this.children) {
                    if(child != null && child.find(word.substring(1))) return true;
                }
                return false;
            } else {
                if(children[tbf - 'a'] != null) return children[tbf - 'a'].find(word.substring(1));
                else return false;
            }
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i ++) {
            if(curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new Node();
            } curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return root.find(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */