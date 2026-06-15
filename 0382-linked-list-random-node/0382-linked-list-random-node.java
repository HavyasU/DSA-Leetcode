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
    ListNode random = null;
    ListNode head = null;
    int len = 0;
    Random rand;

    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
        random = head;
        while(random!=null){
            random = random.next;
            len++;
        }
    }
    
    public int getRandom() {
        int steps = rand.nextInt(len);
        random = head;
        while(steps>0){
            random = random.next;
            steps--;
        }

        return random.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */