class BrowserHistory {
    
    class Node{
        String link;
        Node next=null;
        Node prev=null;
        Node(String link){
            this.link=link;
        }
        Node(String link, Node next, Node prev){
            this.link=link;
            this.prev=prev;
            this.next=next;
        }
    }
    Node stPage;
    public BrowserHistory(String homepage) {
        stPage =new Node(homepage);
    }
    
    public void visit(String url) {
        stPage.next = new Node(url, null, stPage);
        stPage=stPage.next;
    }
    
    public String back(int steps) {
        Node curr= stPage;
        while(steps-->0 && curr.prev!=null ){
            curr=curr.prev;
        }
        stPage=curr;
        return curr.link;
    }
    
    public String forward(int steps) {
        Node curr= stPage;
        while(steps-->0 && curr.next!=null ){
            curr=curr.next;
        }
        stPage=curr;
        return curr.link;
    }
}
// leetcode ->google ->facebook ->youtube
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */