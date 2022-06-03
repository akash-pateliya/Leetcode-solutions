/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curPtr = head;
        Node nextPtr = head;
        
        while(curPtr != null){
            nextPtr = curPtr.next;
            curPtr.next = new Node(curPtr.val);
            curPtr.next.next = nextPtr;
            curPtr = nextPtr;
        }
        
        curPtr = head;
        while(curPtr != null){
            if(curPtr.random != null)
                curPtr.next.random = curPtr.random.next;
            curPtr = curPtr.next.next;
        }
        
        Node dummyHead = new Node(0);
        Node copyPtr = dummyHead;
        curPtr = head;
        nextPtr = head;
        
        while(curPtr != null){
            nextPtr = curPtr.next.next;
            copyPtr.next = curPtr.next;
            curPtr.next = nextPtr;
            copyPtr = copyPtr.next;
            curPtr = nextPtr;
        }
        
        return dummyHead.next;
    }
}