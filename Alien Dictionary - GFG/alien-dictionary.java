//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<N-1; i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            
            int len = Math.min(str1.length(), str2.length());
            for(int k=0; k<len; k++){
                char ch1 = str1.charAt(k);
                char ch2 = str2.charAt(k);
                
                if(ch1 != ch2){
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
            }
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[K];
        
        for(int i=0; i<K; i++){
            if(!visited[i]){
                dfsTopo(i, adj, visited, stack);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            char ch = (char)(stack.pop() + 'a');
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    static void dfsTopo(int vertex,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> stack ){
        visited[vertex] = true;
        
        for(int v: adj.get(vertex)){
            if(!visited[v]){
                dfsTopo(v, adj, visited, stack);
            }
        }
        
        stack.push(vertex);
    }
}