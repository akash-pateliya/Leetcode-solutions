/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode currentNode = head;
        int len = 1;
        
        while(currentNode.next != null){
            len++;
            currentNode = currentNode.next;
        }
        
        // if len < k
        k = k % len;
        k = len - k;
        currentNode.next = head;
        
        while(k != 0){
            k--;
            currentNode = currentNode.next;
        }
        
        head = currentNode.next;
        currentNode.next = null;
        
        return head;
    }
}