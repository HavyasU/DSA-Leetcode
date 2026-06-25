class Solution {

    public char reverse(char c){
        switch(c){
                case '(': return ')';
                case '[': return ']';
                case '{': return '}';
        }
        return 'c';
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stk.add(reverse(c));
            }else{
                if(stk.isEmpty() || stk.pop()!=c) return false;
            }
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}