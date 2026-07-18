class Solution {
    public int[] diStringMatch(String s) {
        int high = s.length();
        int low = 0;
        int perm[] = new int[high+1];

        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'I'){
                perm[i] = low++;
            }else{
                perm[i] = high--;
            }
        }
        perm[perm.length-1] = low;
        return perm;
    }
}