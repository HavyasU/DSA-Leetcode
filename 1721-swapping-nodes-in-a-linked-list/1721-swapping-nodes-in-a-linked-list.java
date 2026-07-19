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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode endptr = head;
        ListNode lastk = head;
        ListNode firstk = head;
        
        int counter = k;
        while(counter-- > 0){
            firstk = endptr;
            endptr = endptr.next;
        }


        while(endptr!=null){
            lastk = lastk.next;
            endptr = endptr.next;
        }

        int temp  = firstk.val;
        firstk.val = lastk.val;
        lastk.val = temp;

        return head;
    }
}