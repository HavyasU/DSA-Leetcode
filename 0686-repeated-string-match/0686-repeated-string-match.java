class Solution {
    public int repeatedStringMatch(String a, String b) {
        int an = a.length();
        int bn = b.length();
        StringBuilder sb = new StringBuilder();
        int rep = bn/an;
        for(int i=1;i<=rep+2;i++){
            sb.append(a);
            if(i<rep) continue;
            if(sb.indexOf(b)>=0){
                return i;
            }
        }
        return -1;
    }
}