class Solution {
    public int minElement(int[] nums) {
        int min = 999;

        for(int ele : nums){
            int sum = 0;
            while(ele!=0)
            {
                sum+=ele%10;
                ele = ele/10;
            }
            if(sum<min){
                min = sum;
            }
        }
        return min;
    }
}