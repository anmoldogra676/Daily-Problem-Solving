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
    ListNode th=null;
    ListNode tt =null;
    public void addFirst(ListNode temp){
        if(th==null){
            th=tt=temp;
            return;
        }
        temp.next = th;
        th=temp;
    }
    
     public void addLast(ListNode temp){
        if(th==null){
            th=tt=temp;
            return;
        }
        
        tt.next=temp;
        tt=tt.next;
    }
    
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = length(head);
        int prev= 0;
        ListNode oh=null;
        ListNode ot=null;
        th=tt=null;
        ListNode curr=head;
        while(len>0 && curr!=null){
            // do the task;
            int sum=prev+1;
            prev=sum;
            if(len<sum && len%2==1){
                // keep as it is
                int n=len;
                while(n-->0){
                    ListNode save =curr.next;
                    addLast(curr);
                    curr=save;
                }
                sum=len;
            }
            else if(len<sum && len%2==0) {
                // return as it is
                int n=len;
                while(n-->0){
                    ListNode save =curr.next;
                    addFirst(curr);
                    curr=save;
                }
                sum=len;
            }
            else {
            if(sum%2==0){
                // even means reverse
                int n=sum;
                while(n-->0){
                    ListNode save =curr.next;
                    addFirst(curr);
                    curr=save;
                }
                
            }
            else{
                // odd means do nothing
               
                int n=sum;
                while(n-->0){
                    ListNode save =curr.next;
                    addLast(curr);
                    curr=save;
                }
            }
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }else{
                ot.next=th;
                ot=tt;
            }
            len-=sum;
            tt=null;
            th=null;
            
        }
        ot.next=null;
        return oh;
    }
}


// --> 1st Group (1)
//     2nd Group (2)