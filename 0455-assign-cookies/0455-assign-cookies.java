class Solution {
    public int findContentChildren(int[] Student, int[] Cookie) {
        int n = Student.length;
        int m = Cookie.length;
        int l = 0, r = 0;
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        while (l < n && r < m) {
            if (Cookie[r] >= Student[l]) {
                l++;
            }
            r++;
        }
        return l; 
    }
}