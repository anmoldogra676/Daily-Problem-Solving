class Solution {
    
    class Node{
        int val;
        int i;
        int j;
        Node(int val, int i, int j){
            this.val=val;
            this.i=i;
            this.j=j;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node>pq=new PriorityQueue<>( (a,b)->{
            return a.val-b.val;
        } );
        int []ans =new int[2];
        int max = Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int st= Integer.MAX_VALUE;
        int range=Integer.MAX_VALUE;
        int k= nums.size();
        for(int i=0;i<k;i++){
            Node n = new Node(nums.get(i).get(0), i, 0);
            max=Math.max(n.val,max);
            pq.add(n);
        }
        end=max;
        st=min;
        while(pq.size()>0){
            Node nn = pq.remove();
            st=nn.val;
            if(end-st<range)
            {
               max=end;
               min=st;
               range=end-st;
            }
            if(nn.j+1 <nums.get(nn.i).size()){
                // element hain abhi 
                end=Math.max(end, nums.get(nn.i).get(nn.j+1));
                pq.add(new Node(nums.get(nn.i).get(nn.j+1), nn.i, nn.j+1));
                
            }else{
                break;
            }
        }
        
        
        
        
        ans[0]=min;
        ans[1]=max;
        return ans;
    }
}