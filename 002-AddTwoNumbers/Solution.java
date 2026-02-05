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
    public static ListNode reverseList(ListNode head){
        ListNode prev =null;
        ListNode next = null;
        ListNode cur = head;

        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode resHead = null;
        ListNode resTail = null;
        int carry =0;


        while(list1!=null  || list2!=null){
            int value1 = list1!=null ? list1.val  : 0;
            int value2 = list2!=null ? list2.val  : 0;
            int resValue = value1+value2+carry;
            carry=0;
            if(resValue > 9){
                int rem = resValue%10;
                carry = resValue/10;
                resValue = rem;
            }
            ListNode newNode = new ListNode(resValue,null);
            if(resHead==null){
                resHead = newNode;
                resTail = newNode;
            }else{
                resTail.next = newNode;
                resTail = newNode;
            }
            if(list1!=null){
                list1 = list1.next;
            }
            if(list2!=null){
                list2 = list2.next;
            }
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry,null);
            resTail.next = newNode;
            resTail = newNode;
        }
        return (resHead);
    }
}