class LRUCache {
    class DLLNode{
        int key, value;
        DLLNode next, prev;
        
        DLLNode(int _key, int _val){
            this.key = _key;
            this.value = _val;
        }
    }
    
    HashMap<Integer, DLLNode> map;
    int size;
    DLLNode head;
    DLLNode tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DLLNode>();
        this.size = capacity;
        
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            int val = node.value;
            deleteNode(node);
            createAndInsertNode(key, val);
            return val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            deleteNode(node);
        }
        else if(map.size() >= this.size){
            DLLNode node = tail.prev;
            deleteNode(node);
        }
        
        createAndInsertNode(key, value);
    }
    
    void deleteNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(node.key);
    }
    
    void createAndInsertNode(int key, int value){
        DLLNode node = new DLLNode(key, value);
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
        
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */