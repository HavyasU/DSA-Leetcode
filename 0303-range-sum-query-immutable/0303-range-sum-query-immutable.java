class NumArray {
    ArrayList<Integer> lst = new ArrayList<Integer>();
    public NumArray(int[] nums) {
        for(int n : nums){
            lst.add(n);
        }
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        while(left<=right){
            sum+=lst.get(left);
            left++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */