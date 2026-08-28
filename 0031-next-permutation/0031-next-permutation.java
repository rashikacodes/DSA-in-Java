class Solution {
        public void nextPermutation(int[] nums) {
        
        int n= nums.length;
        int j= -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                j=i;
                break;
            }
        }
        if(j==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i = n - 1; i > j; i--) {
            if(nums[i] > nums[j]) {
                swap(nums, i, j); 
                break;
            }
        }
          reverse(nums, j + 1, n - 1);
        return;       
        
    }
     private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
}