class Solution {
    public int thirdMax(int[] nums) {
        long min_val = Long.MIN_VALUE;
        long first = min_val;
        long second = min_val;
        long third = min_val;

        for(int num:nums){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }else if(num>second && num!=first){
                third = second;
                second = num;
            }else if(num>third && num!=second && num!=first){
                third = num;
            }
        }

        if(second == min_val){
            return (int)first; 
        }
        if(third == min_val){
            return (int)first;
        }
        return (int)third;
    }
}