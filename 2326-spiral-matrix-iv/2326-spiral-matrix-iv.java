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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int [][]arr = new int[n][m];
        for(int []a:arr)
        Arrays.fill(a ,-1);
        int sr=0; // Starting Row 
        int sc=0; // Starting Column
        int er = n-1; // ending Row
        int ec=m-1; // ending Column
        ListNode curr= head; // Starting point of List 
        int count=m*n;
        while(count>0){ // only doing task when count>0 means traverse each cell
            // top row
            for(int j=sc;j<=ec && count>0;j++){
                if(curr!=null){
                     arr[sr][j]=curr.val;
                    curr=curr.next;
                }
                count--;
            }
            sr++;
            // right 
            if(!(sr<=er && sc<=ec))break;
            for(int j=sr;j<=er&& count>0;j++){
                if(curr!=null){
                    arr[j][ec]=curr.val;
                    curr=curr.next;
                }
                count--;
            }
            ec--;
            // bottom
            for(int i=ec;i>=sc && count>0;i--){
                if(curr!=null){
                     arr[er][i]=curr.val;
                    curr=curr.next;
                }
                count--;
            }
            er--;
            // left
              
            for(int j=er;j>=sr && count >0;j--){
                 if(curr!=null){
                     arr[j][sc]=curr.val;
                    curr=curr.next;
                }
                count--;
            }
            sc++;
        }
        return arr;
    }
}