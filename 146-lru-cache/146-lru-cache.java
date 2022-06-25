class LRUCache {
    Node head = new Node(0, 0);
    Node tail =  new Node(0, 0);
    int size;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
        this.size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(map.get(key));
            insert(key, temp.value);
            return temp.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        
        if(map.size() == this.size){
            remove(tail.prev);
        }
        
        insert(key, value);
    }
    
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
    
    void insert(int key, int value){
        Node node = new Node(key, value);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        
        map.put(key, node);
    }
    
    class Node{
        int key, value;
        Node next, prev;
        Node(int _key, int _val){
            this.key = _key;
            this.value = _val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */