class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            int ele = nums[i];
            int left = i+1;
            int right = n-1;
            int target = 0 - (ele);

            int sum = 0;
            while(left<right){
                sum=nums[left]+nums[right];
                if((sum == target)){
                    if(i<left && left < right && i < right){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(ele);
                    lst.add(nums[left]);
                    lst.add(nums[right]);
                    res.add(lst);
                    }
                    left++;
                    right--;
                }else if(sum>target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return new ArrayList(res);
    }
}