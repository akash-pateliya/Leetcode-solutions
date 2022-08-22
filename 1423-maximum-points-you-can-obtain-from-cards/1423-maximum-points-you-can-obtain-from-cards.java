class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int start=0, end=0;
        int win_size = cardPoints.length - k;
        int sum = 0;
        int ans = 0;
        int total_pts = 0;
        for(int i=0;i < cardPoints.length; i++){
            total_pts = total_pts + cardPoints[i];
        }
        if(cardPoints.length == k){
            return total_pts;
        }
        while(end < cardPoints.length){
            sum = sum + cardPoints[end];
            
            if((end - start + 1) == win_size){
                ans = Math.max(ans, total_pts - sum);
                sum = sum - cardPoints[start];
                start++;
            }
            
            end++;
        }
        
        return ans;
    }
}