class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int n = height.length;
        int high = n-1;
        long max = 0;
        while(low<high){
            long area = Math.min(height[low], height[high]) * (high - low);
            max = Math.max(max,area);
            if(height[low]<height[high]) low++;
            else high-- ;
        }
        return (int) max;
    }
}