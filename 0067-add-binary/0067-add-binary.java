class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sum = new StringBuilder("");

        int i = a.length()-1;
        int j = b.length()-1;

        while(j>=0 || i>=0 || carry!=0){
            int n1=0;
            int n2=0;

            if(i>=0){
                n1 = a.charAt(i)=='1'?1:0;
                i--;
            }
            if(j>=0){
                n2 = b.charAt(j)=='1'?1:0;
                j--;
            }
            System.out.println((n1^n2));
            sum.append(n1^n2^carry);
            carry = (n1&n2) | (n1&carry) | (carry&n2);           
        }

        return sum.reverse().toString();
    }
}