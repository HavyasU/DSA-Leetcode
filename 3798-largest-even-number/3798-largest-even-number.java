class Solution {
    public String largestEven(String s) {
        StringBuilder str = new StringBuilder();
        boolean isValid = false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='2'){
                isValid=true;
            }

            if(isValid){
                str.append(s.charAt(i));
            }

        }

        return str.reverse().toString();
    }
}