//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    static class DLLNode{
        int key, value;
        DLLNode next, prev;
        
        DLLNode(int _key, int _val){
            this.key = _key;
            this.value = _val;
        }
    }
    
    static HashMap<Integer, DLLNode> map;
    static int size;
    static DLLNode head;
    static DLLNode tail;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        map = new HashMap<Integer, DLLNode>();
        size = cap;
        
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        
        head.next = tail;
        tail.prev = head;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            int val = node.value;
            deleteNode(node);
            createAndInsertNode(key, val);
            return val;
        }
        
        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            deleteNode(node);
        }
        else if(map.size() >= size){
            DLLNode node = tail.prev;
            deleteNode(node);
        }
        
        createAndInsertNode(key, value);
    }
    
    static void deleteNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(node.key);
    }
    
    static void createAndInsertNode(int key, int value){
        DLLNode node = new DLLNode(key, value);
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
        
        map.put(key, node);
    }
}
