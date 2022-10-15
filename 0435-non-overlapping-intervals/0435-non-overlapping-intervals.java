class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        
        for(int[] arr: intervals){
            if(arr[0] < end){
                count++;
                if(end > arr[1]){
                    start = arr[0];
                    end = arr[1];
                }
            }
            else{
                start = arr[0];
                end = arr[1];
            }
        }
        return count-1;
    }
}