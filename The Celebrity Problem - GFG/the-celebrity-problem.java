// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st = new Stack<Integer>();
    	for(int i=0; i<n ;i++){
    	    st.push(i);
    	}
    	
    	while(st.size() > 1){
    	    int A = st.pop();
    	    int B = st.pop();
    	    
    	    if(knows(M, A, B)){
    	        st.push(B);
    	    }
    	    else{
    	        st.push(A);
    	    }
    	}
    	
    	int candidate = st.pop();
    	
    	for(int i=0; i<n; i++){
    	    if(candidate != i && M[candidate][i] == 1){
    	        return -1;
    	    }
    	}
    	
    	for(int i=0; i<n; i++){
    	    if(candidate != i && M[i][candidate] == 0){
    	        return -1;
    	    }
    	}
    	
    	return candidate;
    }
    
    static boolean knows(int[][] M,int A,int B){
        return M[A][B] == 1;
    }
}