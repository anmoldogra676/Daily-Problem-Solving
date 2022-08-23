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
    public boolean isPalindrome(ListNode head) {
        ListNode curr= head;
        ListNode mid = midNode(curr);
        ListNode l1= head;
        ListNode l2 = mid.next;
        mid.next= null;
        l2 =helper(l2);
        while(l1!=null && l2!=null){
            if(l1.val!=l2.val)return false;
            l1= l1.next;
            l2= l2.next;
        }
        return true;
        
    }
    public ListNode helper(ListNode head){
        ListNode curr= head;
        ListNode prev =null;
        while(curr!=null){
            ListNode save = curr.next;
            curr.next = prev;
            prev= curr;
            curr= save;
        }
        return prev;
    }
 
    public ListNode midNode(ListNode head){
        ListNode slow= head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}