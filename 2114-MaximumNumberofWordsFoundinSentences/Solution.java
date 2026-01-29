
class Solution {

    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String str : sentences) {
            int len = 0;
            for (char c : str.toCharArray()) {
                len += (c == ' ') ? 1 : 0;
            }
            len += 1;
            if (len > max) {
                max = len;
            }
        }

        return max;
    }
}
