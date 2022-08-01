class NumArray {
    
    class Node{
        int start;
        int end;
        Node left;
        Node right;
        int sum;
        Node(int start, int end){
            this.start=start;
            this.end= end;
            this.left=null;
            this.right=null;
            this.sum=0;
        }
    }
    Node root;
    public NumArray(int[] nums) {
        // make root
        root = build(nums, 0 , nums.length-1);
        // Tree Bn gya segment Tree
    }
    // Buidling The Tree--> 
    public Node build(int[]arr, int i , int j){
        if(i>j)return null;
        if(i==j){
            Node nn =new Node(i,j);
            nn.sum= arr[i];
            return nn;
        } 
        // aisa nhi hai toh recursive tree bnao
        Node nn = new Node(i,j);
        int mid = (i+j)/2;
        nn.left= build(arr, i, mid);
        nn.right= build(arr, mid+1, j);
        nn.sum= nn.left.sum+nn.right.sum;
        return nn;
    }
    
    public void update(int index, int val) {
        // update value toh simply faith
        helper(root, index, val);
    }
    // update the value as well as tree result
    public void helper(Node root, int pos, int val){
        // found leaf node that we want to update
        if(root.start== root.end){
            root.sum= val;
            return;
        }
        // check mid --> for deciding which side to go
        int mid = root.start +(root.end-root.start)/2;
        if(pos<=mid){
            // left part
            helper(root.left, pos, val);
        }else{
            // right part
            helper(root.right, pos, val);
        }
        root.sum = root.left.sum+root.right.sum;
        
    }
    
    // we have to find sum between left and right Range
    public int sumRange(int left, int right) {
        return h(root, left, right);
    }
    
    public int h(Node root, int l, int r){
        // sum calculate krna hai between l, r
        if(root.start==l && root.end==r){
            // same mil gya 
            return root.sum;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(r<=mid){
            // left part m 
            return h(root.left, l, r);
        }else if(l>mid){
            // right part m jao
            return h(root.right, l, r);
        }else
        // consider both
        return h(root.left, l, mid) +h(root.right, mid+1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */