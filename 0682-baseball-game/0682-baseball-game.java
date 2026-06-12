class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stk = new Stack<>();

        for(String ele  : operations){
            switch(ele){
                case "+":
                    stk.push(stk.peek() + stk.get(stk.size()-2));break;
                case "D":
                    stk.push(stk.peek()*2);break;
                case "C":
                    stk.pop();break;
                default: stk.push(Integer.parseInt(ele));
            }
        }

        int sum = 0;
        for(int ele : stk){
            sum+=ele;
        }
        return sum;
    }
}