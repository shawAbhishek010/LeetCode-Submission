class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Next Smaller Element
        int[] nextSmaller = new int[n];
        nextSmaller[n - 1] = n;
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = stack.peek();
            }

            stack.push(i);
        }
        //empting the stack
        stack.clear();

        // Previous Smaller Element
        int[] prevSmaller = new int[n];
        prevSmaller[0] = -1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int rightBoundary = nextSmaller[i];
            int leftBoundary = prevSmaller[i];
            int area = heights[i] * (rightBoundary - leftBoundary - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}