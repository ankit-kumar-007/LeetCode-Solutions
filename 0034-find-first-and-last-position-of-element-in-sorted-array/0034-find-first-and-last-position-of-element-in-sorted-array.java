class Solution {
    public int[] searchRange(int[] nums, int target){ 
        int first = find(nums, target, true);
        int last = find(nums, target, false);

        
        return new int[]{first, last};
    }

    private int find(int[] arr, int target, boolean isFirst){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(target == arr[mid]){
                ans = mid;
                if(isFirst){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}