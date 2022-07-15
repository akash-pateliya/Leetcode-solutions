    public class TrieNode{
        TrieNode[] links;
        boolean isEnd;
        
        TrieNode(){
            this.isEnd = false;
            this.links = new TrieNode[26];
        }
        
        boolean containsChar(char ch){
            return links[ch - 'a'] != null;
        }
        
        void insertChar(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }
        
        TrieNode next(char ch){
            return links[ch - 'a'];
        }
        
        void end(){
            isEnd = true;
        }
        
    }
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)){
                node.insertChar(ch, new TrieNode());
            }
            node = node.next(ch);
        }
        node.end();
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)){
                return false;
            }
            node = node.next(ch);
        }
        
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for(int i=0; i<len; i++){
            char ch = prefix.charAt(i);
            if(!node.containsChar(ch)){
                return false;
            }
            node = node.next(ch);
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