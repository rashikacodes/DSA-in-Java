class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j]++;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int h = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            int left = st.isEmpty() ? -1 : st.peek();
            int width = n - left - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }
}