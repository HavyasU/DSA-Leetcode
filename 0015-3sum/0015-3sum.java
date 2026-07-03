class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int cur = nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + cur;
                if (sum == 0) {
                    lst.add(Arrays.asList(cur, nums[start], nums[end]));
                    // Skip duplicate elements for the second position
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    // Skip duplicate elements for the third position
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return lst;
    }
}