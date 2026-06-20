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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=null;
        ListNode head=null;

        while(list1 !=null && list2!=null){
            if(list1.val <= list2.val){
                if(temp==null){
                    temp = list1;
                    head = temp;
                }else{
                    temp.next = list1;
                    temp = temp.next;
                }
                list1 = list1.next;
            }else{
                if(temp==null){
                    temp = list2;
                    head = temp;
                }else{
                    temp.next = list2;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }

        while(list1!=null){
            if(temp==null){
                temp = list1;
                head = temp;
            }else{
                temp.next = list1;
                temp = temp.next;
            }
            list1 = list1.next;
        }
        while(list2!=null){
            if(temp==null){
                temp = list2;
                head = temp;
            }else{
                temp.next = list2;
                temp = temp.next;
            }
            list2 = list2.next;
        }

        return head; 
    }
}