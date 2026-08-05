class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        for(int j = needle.length(); j <=haystack.length();j++,i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}