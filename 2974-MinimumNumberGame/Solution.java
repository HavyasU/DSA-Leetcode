
class Solution {

    public int[] numberGame(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int val : nums) {
            numbers.add(val);
        }
        Collections.sort(numbers);

        while (!numbers.isEmpty()) {
            int num1 = numbers.remove(0);
            int num2 = numbers.remove(0);

            result.add(num2);
            result.add(num1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
