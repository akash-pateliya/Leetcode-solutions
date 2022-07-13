// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class Tuples{
        int data;
        int row;
        int col;
        
        Tuples(int d, int r, int c){
            this.data = d;
            this.row = r;
            this.col = c;
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Tuples> minHeap = new PriorityQueue<Tuples>(new Comparator<Tuples>(){
            public int compare(Tuples a, Tuples b){
                return a.data - b.data;
            }
        });
        
        for(int i=0; i<arr.length; i++){
            minHeap.add(new Tuples(arr[i][0], i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!minHeap.isEmpty()){
            Tuples top = minHeap.remove();
            ans.add(top.data);
            if(top.col + 1 < arr[top.row].length){
                minHeap.add(new Tuples(arr[top.row][top.col+1],top.row, top.col+1));
            }
        }
        return ans;
    }
}