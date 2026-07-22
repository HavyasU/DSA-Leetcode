class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char letters[] = new char[n];
        for(int i=0;i<n;i++){
            letters[indices[i]] = s.charAt(i);
        }
        return new String(letters);
    }
}