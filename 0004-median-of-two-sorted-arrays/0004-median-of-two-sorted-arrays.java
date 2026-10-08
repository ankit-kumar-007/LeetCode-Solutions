class Solution {

    int[] merge(int[] a, int[] b) {
    int[] res = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length) {
        if (a[i] <= b[j])
            res[k++] = a[i++];
        else
            res[k++] = b[j++];
    }

    while (i < a.length) res[k++] = a[i++];
    while (j < b.length) res[k++] = b[j++];

    return res;
}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        int n = arr.length;

        if (n%2 == 1) {
            return arr[n/2];
        } else {
            return ((double) arr[n/2 - 1] + arr[n/2])/2;
        }
    }
}