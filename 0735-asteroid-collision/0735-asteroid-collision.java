class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int n = asteroids.length;
        for(int i=n-1;i>=0;i--){
            int cur = asteroids[i]; 
            boolean destroyed = false; 
            while(!stk.isEmpty() && cur>0 && stk.peek() < 0 ){

                int last = stk.peek();
                int abslast = Math.abs(last);
                int abscur = Math.abs(cur);
      
                if(abslast == abscur){
                    stk.pop();
                    destroyed = true;
                    break;
                }else if(abslast > abscur){
                    destroyed = true;
                    break;
                }else{
                    stk.pop();
                }
                
            }
            if(!destroyed){
                    stk.push(cur);
            }
        }
        int arr[] = new int[stk.size()];
        int idx = 0;
        while(!stk.isEmpty()){
            arr[idx++] = stk.pop();
        }
        return arr;
    }
}