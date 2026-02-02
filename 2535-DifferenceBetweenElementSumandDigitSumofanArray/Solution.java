
class Solution {

    public int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }

        return sum;
    }

    public int differenceOfSum(int[] nums) {
        int digitSum = 0;
        int eleSum = 0;

        for (int num : nums) {
            digitSum += getDigitSum(num);
            eleSum += num;
        }

        return Math.abs(eleSum - digitSum);

    }
}
