class Trie {

    class TrieNode{
        TrieNode[] links;
        boolean isEnd;
        
        TrieNode(){
            this.links = new TrieNode[26];
            this.isEnd = false;
        }
        
        boolean contains(char ch){
            return this.links[ch - 'a'] != null;
        }
        
        void insert(char ch){
            this.links[ch - 'a'] = new TrieNode();
        }
        
        TrieNode get(char ch){
            return this.links[ch - 'a'];
        }
    }
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                node.insert(ch);
            }
            node = node.get(ch);
        }
        
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        
        for(int i=0; i<len; i++){
            char ch = prefix.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */