
class Solution {

    public int countDigits(int num) {
        int devidend = num;
        int count = 0;

        while (num > 0) {
            int rem = num % 10;

            if (devidend % rem == 0) {
                count += 1;
            }

            num = num / 10;
        }

        return count;

    }
}
