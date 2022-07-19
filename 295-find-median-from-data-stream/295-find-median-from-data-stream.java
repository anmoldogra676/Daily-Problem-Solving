class MedianFinder {
    // Median  -->sorted array m left and right m equal element ho ya ek jyada ho
    // 2 priority queue bnanyenge 
    // sorted order maintain krna pdega median k left m sb chote right m bde 
    // median --> left walon m largest , right m smallest
    // 2 PQ --> MAX (LEFT) , MIN (RIGHT);
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>((a,b)->{
            return b-a; });
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(left.size()==0  || left.peek()>=num) left.add(num);
        else right.add(num);
        
        if(left.size()>right.size()+1){
            right.add(left.poll());
        }
        if(right.size()>left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek() + right.peek())/2.0;
        }
        return left.peek();
    }
}
/*
class MedianFinder {
//     // Number aaye ja rhe hain 
//     // toh insertion sort
//     ArrayList<Integer>arr;
//     public MedianFinder() {
//         arr = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
        
//         arr.add(num);
//         int n=arr.size();
//         if(n==1)return;
//         int i=n-1;
//         while(i>0){
//             if(arr.get(i-1)>num){
//                 arr.set(i, arr.get(i-1));
//                 i--;
//             }
//             else break;
//         }
//         arr.set(i, num);
//     }
    
//     public double findMedian() {
//         int n= arr.size();
//         if(n%2==1){
//             return arr.get(n/2)*1.0;
//         }else{
//             int val = arr.get(n/2);
//             int val1 = arr.get(n/2-1);
//             return (val+val1)/2.0;
//         }
//     }
// }
*/
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */