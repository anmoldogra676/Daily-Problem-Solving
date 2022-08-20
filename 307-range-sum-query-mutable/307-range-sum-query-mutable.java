// Fenwick Tree
class NumArray {
    
    class ftree{
        int []ft;
        ftree(int []nums){
            ft= new int[nums.length+1];
            for(int i=0;i<or.length;i++){
                int pos = i+1;
                update(pos,nums[i]);
            }
        }
        private int rsb(int x){
            return x&-x;
        }
        int getsum (int pos){
            int val=0;
            while(pos>0){
                val+=ft[pos];
                pos-=rsb(pos);
            }
            return val;
        }
        void update(int pos, int delta){
            while(pos<ft.length){
                ft[pos]+=delta;
                pos = pos+rsb(pos);
            }
            
        }
        
    }
    int [] or;
    ftree node;
    public NumArray(int[] nums) {
        or= nums;
        node = new ftree(nums);
        
    }
    
    public void update(int index, int val) {
        int delta = val-or[index];
        node.update(index+1,delta);
        or[index]=val;
    }
    
    public int sumRange(int left, int right) {
        // now we have to calculate the sum
        int lpos = left+1;
        int rpos = right+1;
        int leftSum = node.getsum(lpos-1);
        int rightSum = node.getsum(rpos);
        return rightSum-leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */