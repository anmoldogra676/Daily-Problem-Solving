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
    public ListNode partition(ListNode head, int x) {
        ListNode fh =new ListNode(-1);
        ListNode dummy =fh;
        ListNode curr= head;
        if(head==null || head.next==null)return head;
        while(curr!=null){
            if(curr.val<x){
                dummy.next=new ListNode(curr.val);
                dummy=dummy.next;
            }
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.val>=x){
                dummy.next=new ListNode(curr.val);
                dummy=dummy.next;
            }
            curr=curr.next;
        }
        return fh.next;
    }
}