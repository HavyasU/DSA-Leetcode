class Solution {
    public boolean isOperator(String operator){
        return operator.equals("+") || operator.equals("-") || operator.equals("*")  ||  operator.equals("/") ;
    }
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String c: tokens){
            if(isOperator(c)){
                int n2 = Integer.valueOf(st.pop());
                int n1 = Integer.valueOf(st.pop());
                int result =0;

                if(c.equals("+")){
                    result = n1+n2;
                }else if(c.equals("-")){
                    result = n1-n2;
                } else if(c.equals("*")){
                    result = n1*n2;
                }else if(c.equals("/")){
                    result = n1/n2;
                }



                st.push(String.valueOf(result));
            }else{
                st.push(String.valueOf(c));
            }
        }
        return Integer.valueOf(st.pop());
    }
}