
class Solution {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                char ch = (char) (c + 32);
                sb.append(ch);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
