// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    static class Pair{
        int value;
        int index;
        
        Pair(int a, int b){
            this.value = a;
            this.index = b;
        }
    }
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        int[] ans = getPreviousGreaterElementIndex(price);
        
        for(int i=0; i<n; i++){
            ans[i] = i - ans[i];
        }
        
        return ans;
    }
    
    static int[] getPreviousGreaterElementIndex(int[] arr){
        Stack<Pair> st = new Stack<Pair>();
        int[] ans = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && st.peek().value <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek().index;
            }
            
            st.push(new Pair(arr[i], i));
        }
        
        return ans;
    }
}