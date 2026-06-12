class Solution {
    public int minOperations(String[] logs) {
        int count=0;

        for(String log : logs){
            switch(log){
                case "../":
                    if(count>0)
                    count--;
                    break;
                case "./":
                    break;
                default:
                    count++;
            }
        }

        return count;
    }
}