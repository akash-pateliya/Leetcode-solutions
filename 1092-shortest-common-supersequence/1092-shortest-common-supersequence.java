class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = getDpTable(str1, str2);
        StringBuilder sb = new StringBuilder();
        
        int i=dp.length - 1;
        int j = dp[0].length - 1;
        
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                //up
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        
        while(i > 0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    public int[][] getDpTable(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i=0; i<=str1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=str2.length(); j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
            
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        
        return dp;
    }
}