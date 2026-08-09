class MedianFinder {
   PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> mn = new PriorityQueue<>();

    public void addNum(int num) {
        if (mx.isEmpty() || num <= mx.peek()) mx.offer(num);
        else mn.offer(num);

        if (mx.size() > mn.size() + 1) {
            mn.offer(mx.poll());
        } else if (mn.size() > mx.size()) {
            mx.offer(mn.poll());
        }
    }

    public double findMedian() {
        if (mx.size() == mn.size()) return (mx.peek() + mn.peek()) / 2.0;
        return mx.peek();
    }
}