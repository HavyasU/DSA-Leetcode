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
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        if(len == 0 || len==1 || k==0){
            return head;
        }

        k = k % len;
        // 4 % 3 = 1
        // 2 % 5 = 2
        k = k % len;
if (k == 0) return head;

        int ind = 1;
        temp = head;
        ListNode nextPart = null;
        while(ind<(len-k)){
            temp = temp.next;
            ind++;
        }
        nextPart = temp.next;
        temp.next = null;

        temp = nextPart;
        while(nextPart.next!=null){
            nextPart = nextPart.next;
        }

        nextPart.next = head;

        return temp;
    }
}