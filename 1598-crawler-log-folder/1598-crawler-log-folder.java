class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();

        for(String log : logs){
            switch(log){
                case "../":
                    if(!stk.isEmpty())
                    stk.pop();
                    break;
                case "./":
                    break;
                default:
                    stk.push(log);
            }
        }

        return stk.size();
    }
}