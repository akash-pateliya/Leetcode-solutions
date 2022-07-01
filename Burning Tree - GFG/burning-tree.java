// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static Node assignedParent(Node root, int target,HashMap<Node, Node> map){
        Queue<Node> queue = new LinkedList<Node>();
        Node res = null;
        queue.add(root);
        while(!queue.isEmpty()){
            Node top = queue.remove();
            if(top.data == target){
                res = top;
            }
            
            if(top.left != null){
                map.put(top.left, top);
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
                map.put(top.right, top);
            }
        }
       
        return res;
    }
    static int burnTree(Node root, HashMap<Node, Node> map){
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
        visited.put(root, true);
        queue.add(root);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            boolean flag = false;
            for(int i=0; i<size; i++){
                Node top = queue.remove();
                
                if(top.left != null && visited.get(top.left) == null){
                    flag = true;
                    visited.put(top.left, true);
                    queue.add(top.left);
                }
                if(top.right != null && visited.get(top.right) == null){
                    flag = true;
                    visited.put(top.right, true);
                    queue.add(top.right);
                }
                if(map.containsKey(top) && visited.get(map.get(top)) == null){
                    flag = true;
                    visited.put(map.get(top), true);
                    queue.add(map.get(top));
                }
            }
            if(flag){
                time++;
            }
        }
        return time;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node tar = assignedParent(root, target, map);
        
        return burnTree(tar, map);
    }
}