class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) 
                    ans[i] = -1;
                else 
                    ans[i] = st.peek();

            st.push(nums2[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums2[i], ans[i]);
        }

        int[] ans2 = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans2[i] = map.get(nums1[i]);
        }

        return ans2;
    }
}