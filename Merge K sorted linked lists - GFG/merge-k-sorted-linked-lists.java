// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a

/*
Priority Queue
{
        //Add your code here.
        PriorityQueue<Node>pq = new PriorityQueue<>((a,b)->{
            return a.data-b.data;
        } ); //min 
        
        for(int i=0;i<K;i++){
            pq.add(arr[i]); // 
        }
        Node head = null;
        Node tail = null;
        while(pq.size()>0){
            Node min = pq.remove();// minimum element mre pass aa gya
            if(head==null){
                head= min;
                tail=min;
                if(tail.next!=null){
                    pq.add(tail.next);
                }
            }else{
                // list hia =--> tial 
                tail.next = min;
                tail= tail.next;
                if(tail.next!=null){
                    pq.add(tail.next);
                }
                
            }
            
        }
        
        return head;
        
    }
*/

class Solution
{
    //Function to merge K sorted linked list.
    // O(nk log k)
    Node mergeKList(Node[]arr,int K)
    {
        if(K==1)return arr[0];
        return helper(arr, 0, K-1);
    }
    public Node helper(Node[]arr, int i, int j){
       
        if(i==j)return arr[i];
        int mid= (i+j)/2;
        Node l = helper(arr, i, mid);
        Node r = helper(arr, mid+1, j);
        return MergeTwoList(l, r);
    }
    public Node MergeTwoList(Node m, Node n){
        Node dummy = new Node(-1);
        Node curr= dummy;
        Node l=m;
        Node r= n;
        while(l!=null && r!=null){
            int val1 = l.data;
            int val2 = r.data;
            if(val1<=val2){
                curr.next = l;
                l=l.next;
            }else{
                curr.next=r;
                r=r.next;
            }
            curr=curr.next;
        }
        curr.next = (l!=null)?l:r;
        return dummy.next;
    }
}
