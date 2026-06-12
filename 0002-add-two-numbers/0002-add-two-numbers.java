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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lst = null;
        ListNode res = null;
         int carry = 0;
         int cur = 0;
        while(l1!=null && l2!=null){
            int val = l1.val + l2.val + carry;
            cur = val % 10;
            carry = val/10;

            if(lst == null){
                lst = new ListNode(cur);
                res = lst;
            }else{
                lst.next = new ListNode(cur);
                lst = lst.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int val = l1.val+carry;
            cur = val % 10;
            carry = val/10;
            lst.next = new ListNode(cur);
            lst=lst.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int val = l2.val+carry;
            cur = val % 10;
            carry = val/10;
            lst.next = new ListNode(cur);
            l2 = l2.next;
            lst=lst.next;;
        }

        if(carry>0){
            lst.next = new ListNode(carry);
 
        }

        return res;
    }
}