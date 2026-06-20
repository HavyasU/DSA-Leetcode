class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;

        int temp[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int ele = temperatures[i];
            while(!stk.isEmpty() && temperatures[stk.peek()]<=ele)
                stk.pop();
            if(stk.isEmpty()){
                temp[i] = 0;
            }else{
                temp[i] = stk.peek()-i;
            }
            stk.add(i);
        }
        return temp;
    }
}