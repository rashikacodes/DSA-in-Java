class Solution {

    public int solve(int[] nums, int k) {

        int n = nums.length;
        int cnt = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int l = 0, r = 0;

        while (r < n) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if (mpp.get(nums[l]) == 0) {
                    mpp.remove(nums[l]);
                }
                l++;
            }

            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }
}