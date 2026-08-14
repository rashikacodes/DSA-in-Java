class Solution {
    int jump(int[] nums) {
        int maxIndex = 0 , currentEnd=0,jumps=0;
          for (int i = 0; i < nums.length-1; i++) {
            
            maxIndex = Math.max(maxIndex, i + nums[i]);
              if (i == currentEnd) {
                jumps++;
                currentEnd = maxIndex;
            }
          } return jumps;
        }
       
    }
