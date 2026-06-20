class Solution {
    public char reverse(char c){
        if(c==')'){
            return '(';
        }
        if(c==']'){
            return '[';
        }
        if(c=='}'){
            return '{';
        }
        return '\0';
    }
    public boolean isValid(String s) {
        if(s.length() %2 != 0) return false;
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='(' || c=='['  || c=='{'){
                stk.add(c);
            }else{
                if(stk.isEmpty()) return false;
                if(stk.pop() != reverse(c)){
                    return false;
                }
            }
        }

        if(stk.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}