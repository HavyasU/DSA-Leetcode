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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while(temp!=null){
            temp=temp.next;
            count++;
        }

        int res = 0;
        temp = head;
        count--;
        while(temp!=null){
            if(temp.val  == 1){
                res += Math.pow(2,count);
            }
            temp= temp.next;
            count--;
        }

        return res;
    }
}