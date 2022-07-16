class Solution {
    class Trie{
        Trie[] links;
        
        Trie(){
            this.links = new Trie[2];
        }
        
        boolean contains(int bit){
            return links[bit] != null;
        }
        
        void insert(int bit, Trie node){
            links[bit] = node;
        }
        
        Trie get(int bit){
            return links[bit];
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        
        for(int num: nums){
            insertIntoTrie(root, num);
        }
        
        int max = 0;
        
        for(int num: nums){
            max = Math.max(max, getMax(root, num));
        }
        
        
        return max;
    }
    
    int getMax(Trie root, int num){
        Trie node = root;
        int max = 0;
        for(int i  = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.contains(1 - bit)){
                max = max | (1 << i);
                node =  node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return max;
    }
    
    void insertIntoTrie(Trie root, int num){
        Trie node = root;
        for(int i= 31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!node.contains(bit)){
                node.insert(bit, new Trie());
            }
            node = node.get(bit);
        }
    }
}