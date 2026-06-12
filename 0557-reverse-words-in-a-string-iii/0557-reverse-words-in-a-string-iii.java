class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] st = s.split(" ");


        for(String str: st){
            char[] c = str.toCharArray();
            int left = 0;
            int right = c.length-1;
            while(left<right){
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            sb.append(new String(c)+" ");
        }

        return sb.toString().trim();
    }
}