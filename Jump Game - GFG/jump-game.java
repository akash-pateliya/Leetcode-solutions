//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] nums, int N) {
        // code here
        int n = nums.length;
        boolean[] dp = new boolean[n];
        
        dp[n-1] = true;
        
        for(int i=n-2; i>=0; i--){
            if(nums[i] == 0){
                dp[i] = false;
                continue;
            }
            int maxJump = i + nums[i];
            boolean flag = false;
            for(int jump = i+1; jump <= maxJump; jump++){
                if(jump < nums.length && dp[jump]){
                    flag = true;
                    dp[i] = true;
                    break;
                }
            }
            
            if(flag){
               continue; 
            }
            dp[i] = false;
        }
        
        return dp[0] ? 1 : 0;
    }
};