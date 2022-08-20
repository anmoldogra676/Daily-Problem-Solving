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
        or =nums;
        node = new ftree(nums);
    }
    
    public int sumRange(int left, int right) {
        int pos1 = left+1;
        int pos2 = right+1;
        int leftSum = node.getsum(pos1-1);
        int rightSum = node.getsum(pos2);
        return rightSum-leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */