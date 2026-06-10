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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;
    
        if(head.next == null){
            return head.next;
        }
        int count=0; //nodecount
        while(fast!=null){
            fast = fast.next;
            
            if(count >= n){
                tail = slow;
                slow = slow.next;
            }

            if(count<n){
                count++;
            }
        }
        if(tail == null){
            head = head.next;
        }
        if(tail != null && tail.next!=null){
            tail.next =tail.next.next;
        }

        
        return head;
    }
}