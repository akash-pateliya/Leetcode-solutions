class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        
        int[][] dp = new int[words.length+1][words.length+1];
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return getMaxLen(0, -1, words, dp);
    }
    
    int getMaxLen(int i, int prev, String[] words, int[][] dp){
        if(i == words.length){
            return 0;
        }
        
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        
        int len = getMaxLen(i+1, prev, words, dp);
        if(prev == -1 || compareString(words[i], words[prev])){
            len = Math.max(len,1 + getMaxLen(i+1, i, words, dp));
        }
        
        dp[i][prev+1] = len;
        
        return len;
    }
    
    boolean compareString(String str1, String str2){
        if(str1.length() != str2.length() + 1){
            return false;
        }
        
        int ptr1=0, ptr2=0;
        
        while(ptr1 < str1.length()){
            if(ptr2 < str2.length() && str1.charAt(ptr1) == str2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }
            else{
                ptr1++;
            }
        }
        
        return (ptr1 == str1.length() && ptr2 == str2.length());
    }
}