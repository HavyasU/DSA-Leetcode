class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for(char c : s.toCharArray()){
            if(c=='('){
                left++;
            }else{
                right++;

                if(right>left){
                    left = 0; 
                    right = 0;
                }
            }
            if(left==right){
                max = left*2 > max ? left*2 : max;
            }
        }
        
        left = 0;
        right = 0;

        for(char c : new StringBuilder(s).reverse().toString().toCharArray()){
            if(c==')'){
                left++;
            }else{
                right++;

                if(right>left){
                    left = 0; 
                    right = 0;
                }
            }
            if(left==right){
                max = left*2 > max ? left*2 : max;
            }
        }


        return max;
    }
}