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
    public ListNode middleNode(ListNode head) {
        ListNode list  = head;
        int count = 0;
        while(list!=null){
            count++;
            list = list.next;
        }
        int idx = 1;
        list = head;
        while(idx < (int)((count/2)+1)){
            idx++;
            list = list.next;
        }
        System.out.println(idx);
        return list;
    }
}