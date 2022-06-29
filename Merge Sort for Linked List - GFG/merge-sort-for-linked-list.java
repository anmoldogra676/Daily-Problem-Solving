// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */
// 1 2 3 4 5 6
class Solution
{
    public static Node mid (Node head){
        if(head==null)return head;
        Node curr= head;
        Node temp= head;
        while(curr.next!=null && curr.next.next!=null){
            temp=temp.next;
            curr=curr.next.next;
        }
        return temp;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null|| head.next==null)return head;
        // divide and conquer tech
        Node midNode = mid(head);
        Node save =midNode.next;
        midNode.next=null;
        Node left = mergeSort(head);
        Node right = mergeSort(save);
        return merge(left, right);
    }
    static public Node merge(Node left, Node right){
        Node curr= new Node(-1);
        Node temp =curr;
        while(left!=null && right!=null){
            if(left.data>=right.data){
                temp.next=right;
                temp=temp.next;
                right=right.next;
            }else{
                 temp.next=left;
                temp=temp.next;
                left=left.next;
            }
        }
        if(left==null)temp.next=right;
        else temp.next= left;
        return curr.next;
    }
}


