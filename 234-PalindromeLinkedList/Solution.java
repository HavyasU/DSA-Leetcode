
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

    public boolean isPalindrome(ListNode head) {
        ListNode Middle = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            Middle = Middle.next;
            p2 = p2.next.next;
        }

        ListNode prev = null, cur = head, next = null;

        while (cur != Middle) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        if (p2 != null) {
            Middle = Middle.next;
        }

        //compare two..
        //one starts from 'middle' and another from 'prev'
        while (Middle != null || prev != null) {
            if (Middle.val != prev.val) {
                return false;
            }
            Middle = Middle.next;
            prev = prev.next;
        }

        return true;

    }
}
