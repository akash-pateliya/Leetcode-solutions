class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size() > k){
                    maxHeap.remove();
                }
            }
        }
        
        return maxHeap.peek();
    }
}