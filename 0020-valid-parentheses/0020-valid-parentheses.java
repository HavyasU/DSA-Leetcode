class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='(') stk.add(')');
            else if(c=='[') stk.add(']');
            else if(c=='{') stk.add('}');
            else{
                if(stk.isEmpty()) return false;
                if(stk.pop() != c){
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