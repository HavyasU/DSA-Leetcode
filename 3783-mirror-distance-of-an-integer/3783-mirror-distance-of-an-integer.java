class Solution {
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int rev = Integer.parseInt(sb.reverse().toString());

        return Math.abs(n-rev);
    }
}