//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int pf_needed = 1;
        int max = 1;
        
        int i = 1;
        int j = 0;
        
        while(i < arr.length && j < dep.length){
            if(arr[i] > dep[j]){
                j++;
                pf_needed--;
            }
            else{
                i++;
                pf_needed++;
            }
            
            if(pf_needed > max){
                max = pf_needed;
            }
        }
        
        return max;
        // o(n) * 2400
        // int[] dp = new int[2401];
        // Arrays.fill(dp, 0);
        // int max = 0;
        // for(int i=0; i<n; i++){
        //     for(int start=arr[i]; start <= dep[i]; start++){
        //         dp[start] = dp[start] + 1;
        //         max = Math.max(max, dp[start]);
        //     }
        // }
        
        // return max;
    }
    
}

