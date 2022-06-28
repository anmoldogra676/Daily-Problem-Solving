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
    public int length(ListNode head){
       
        ListNode curr=head;
        int len=0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        return len;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)return null;
        int len = length(head);
        len=len/2;
        ListNode ele = helper(head,len);
        ele.next =ele.next.next;
        return head;
    }
    public ListNode helper(ListNode head, int k){
        ListNode curr= head;
        k=k-1;
        while(k-->0){
            curr=curr.next;
        }
        return curr;
    }
}