class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove out of range numbers window size is i-k so removal of window element is required
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // if elements are smaller than curr element then remove upto the point where they are smaller
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);// add current window
            if (i >= k - 1) { // update the answer when window starts
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}