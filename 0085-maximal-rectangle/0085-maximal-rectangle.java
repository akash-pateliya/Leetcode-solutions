class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        
        int max = Integer.MIN_VALUE;
        
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == '0'){
                    heights[col] = 0;
                }
                else{
                    heights[col] = heights[col] + 1;
                }
            }
            
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    int largestRectangleArea(int[] heights) {
        int[] previousSmaller = getPreviousSmaller(heights);
        int[] nextSmaller = getNextSmaller(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            if(nextSmaller[i] == -1){
                nextSmaller[i] = heights.length;
            }
            int area = heights[i] * (nextSmaller[i] - previousSmaller[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    int[] getPreviousSmaller(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    int[] getNextSmaller(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[arr.length];
        for(int i=arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}