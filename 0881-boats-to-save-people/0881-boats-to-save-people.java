class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int start = 0;
        int end = n-1;
        int count = 0;

        while(start<=end){
           if(start!=end && people[start]+people[end] <= limit){
            start++;
            end--;
            count++;
           }else if(people[end]<=limit){
            end--;
            count++;
           }else if(people[start] <= limit){
            start++;
            count++;
           }
        }
        return count;
    }
}