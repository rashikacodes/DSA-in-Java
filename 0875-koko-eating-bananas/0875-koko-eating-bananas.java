
class Solution {
      private int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
     private long calculateTotalHours(int[] v, int hourly) {
        long totalH = 0;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) v[i] / (double) hourly);
        }
        return totalH;

    }
     public int minEatingSpeed(int[] nums, int h) {
        int low = 1, high = findMax(nums);
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH = calculateTotalHours(nums, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}