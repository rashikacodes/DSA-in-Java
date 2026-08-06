import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add frequencies to heap
        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            // Process one cycle of (n + 1) intervals
            for (int i = 0; i <= n; i++) {

                if (!pq.isEmpty()) {
                    int count = pq.poll();
                    count--;

                    if (count > 0) {
                        temp.add(count);
                    }
                }

                time++;

                // If all tasks are completed, return
                if (pq.isEmpty() && temp.isEmpty()) {
                    return time;
                }
            }

            // Add remaining frequencies back into heap
            for (int count : temp) {
                pq.offer(count);
            }
        }

        return time;
    }
}