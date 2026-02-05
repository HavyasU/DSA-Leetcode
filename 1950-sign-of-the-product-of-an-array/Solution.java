class Solution {
    public int signFunc(int x){
        if(x>0){
            return 1;
        }else if(x<0){
            return -1;
        }else{
            return 0;
        }
    }
    public int arraySign(int[] nums) {
        int prod = 1;
        for(int n : nums){
            prod*=signFunc(n);
        }
        return prod;
    }
}