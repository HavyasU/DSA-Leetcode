class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        boolean isPalindrome = true;

        while(left<right){
            while(left<right && !Character.isLetter(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetter(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            {
                isPalindrome = false;
                break;
            }
            right--;
            left++;           
        }
        return isPalindrome;


    }
}