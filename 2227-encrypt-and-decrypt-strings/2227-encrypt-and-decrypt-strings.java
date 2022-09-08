class Encrypter {
    HashMap<Character, String> enc = new HashMap<>();
    HashMap<String, Integer> count = new HashMap<>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        int n = keys.length;
        for(int i = 0; i < n; i ++) {
            enc.put(keys[i], values[i]);
        }
        for(String s : dictionary) {
            String x = encrypt(s);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word1.length(); i ++) 
            sb.append(enc.getOrDefault(word1.charAt(i), "#"));
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return count.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */