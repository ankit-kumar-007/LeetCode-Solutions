class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];
        long maxDiff = 0;
        long sumDiff = 0;

        for (int i=0; i<n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sumDiff += diff[i];
        }

        if (sumDiff <= k) {
            return 0;
        }

        long left = 0, right = maxDiff;

        while (left < right) {
            long mid = left + (right-left)/2;
            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long threshold = left;
        long operationsUsed = 0;
        long answer = 0;

        for (int i=0; i<n; i++) {
            if (diff[i] > threshold) {
                operationsUsed += diff[i] - threshold;
                diff[i] = threshold;
            }
        }

        long remaining = k - operationsUsed;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == threshold && threshold > 0) {
                diff[i]--;
                remaining--;
            }
        }

        for (long d : diff) {
            answer += d*d;
        }

        return answer;
    }
}