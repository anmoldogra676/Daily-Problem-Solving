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
    public ListNode removeElements(ListNode head, int x) {
         ListNode fh =new ListNode(-1);
        ListNode dummy =fh;
        ListNode curr= head;
        if(head==null || (head.next==null && head.val==x)) return null;
        while(curr!=null){
            if(curr.val!=x){
                dummy.next=curr;
                dummy=dummy.next;
            }
            curr=curr.next;
        }
        dummy.next=null;
        return fh.next;
    }
}