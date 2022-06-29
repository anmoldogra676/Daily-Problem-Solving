class LRUCache {
    class Node{
        int key; 
        int value;
        Node next, prev;
        Node(int key, int value,Node next, Node prev){
            this.next=next;
            this.prev =prev;
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer, Node>hs;
    Node head;// dummy liye hai 
    Node tail;// dummy liye hai
    int cap;
    public LRUCache(int capacity) {
        hs= new HashMap<>();
        cap=capacity;
        head= new Node(-2,-2,null,null);
        tail = new Node(-2,-2,null,null);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public void remove(Node n){
        hs.remove(n.key);// hashMap m remove krunga
        n.prev.next = n.next;
        n.next.prev= n.prev;
        // remove ho gya
        
    }
    public void insert(int k, int v){
        // insert at head krna hai mujhe
        Node n =new Node(k,v,null,null);
        hs.put(n.key,n);// hashMap m remove krunga
        n.next = head.next;
        head.next.prev=n;
        head.next=n; // keep head as it is
        n.prev=head; // Maintains pointer
    }
    
    public int get(int key) {
        if(hs.containsKey(key)==false)return -1;
        int val =hs.get(key).value;
        remove(hs.get(key));
        insert(key,val);
        return hs.get(key).value;
    }
    
    public void put(int key, int value) {
        if(hs.containsKey(key)){
            Node nn = hs.get(key);
            remove(nn);
            insert(key,value);
            return;
        }
        if(hs.size()==cap){
            remove(tail.prev);
        }
        insert(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */