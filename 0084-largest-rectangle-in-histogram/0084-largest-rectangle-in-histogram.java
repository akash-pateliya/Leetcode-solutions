class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = getNextSmaller(heights);
        int[] previousSmaller = getpreviousSmaller(heights);
        
        int maxArea = Integer.MIN_VALUE;
        
        for(int i=0; i<heights.length; i++){
            if(nextSmaller[i] == -1){
                nextSmaller[i] = heights.length;
            }
            int area = (nextSmaller[i] - previousSmaller[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
    
    int[] getNextSmaller(int[] heights){
        int[] ans = new int[heights.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=heights.length - 1; i>=0; i--){
            
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.empty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        return ans;
    }
    
    int[] getpreviousSmaller(int[] heights){
        int[] ans = new int[heights.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<heights.length; i++){
            
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.empty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        return ans;
    }
}