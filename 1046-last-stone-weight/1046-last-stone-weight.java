class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            minHeap.add(stone);
        }

        while(minHeap.size() >=2){
            int y = minHeap.poll();
            int x = minHeap.poll();
            if(x != y){
                int newVal = y - x;
                if(newVal > 0) minHeap.add(newVal);
            }
        }

        if(minHeap.size() == 0) return 0;
        return minHeap.poll();
    }
}