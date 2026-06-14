class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int counter = 0;
        int maxcounter = 0;
        for(int i=0;i<n;i++){
            if(nums[i] ==  1){
                counter++;
            }else{
                counter=0;
            }
            if(counter > maxcounter){
                maxcounter = counter;
            }
        }

        return maxcounter;
    }
}