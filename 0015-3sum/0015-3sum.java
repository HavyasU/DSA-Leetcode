class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> lst = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int start = i + 1;
            int end = n - 1;
            List<Integer> sub = new ArrayList<>();
            while (start < end) {
                int sum = nums[start] + nums[end] + cur;
                if (sum == 0) {
                    sub.add(cur);
                    sub.add(nums[start]);
                    sub.add(nums[end]);
                    lst.add(sub);
                    sub = new ArrayList<>();
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return new ArrayList<>(lst);
    }
}