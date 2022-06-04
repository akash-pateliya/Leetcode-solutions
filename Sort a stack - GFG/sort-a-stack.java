// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		solve(s);
		return s;
	}
	
	static void solve(Stack<Integer> stack){
	    if(stack.empty()){
	        return;
	    }
	    
	    int top = stack.pop();
	    
	    solve(stack);
	    
	    insert(top, stack);
	}
	
	static void insert(int ele, Stack<Integer> stack){
	    if(stack.empty() || stack.peek() <= ele){
	        stack.push(ele);
	        return;
	    }
	    
	    int top = stack.pop();
	    
	    insert(ele, stack);
	    stack.push(top);
	}
}