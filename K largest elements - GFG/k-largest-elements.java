// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        while(!minHeap.isEmpty()){
            ans.add(0, minHeap.remove());
        }
        return ans;
    }
}