class Solution {
    public long[] sumOfThree(long num) {
        long mid = num/3;
        long res = mid+(mid-1)+(mid+1);

        if(res != num){
            return new long[]{};
        }else{
            return  new long[] {mid-1, mid, mid+1};
        }
    }
}