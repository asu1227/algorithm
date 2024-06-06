public class BinarySearch {
    /**左闭右开区间二分查找, 实际应用中可以维护两个区间都为闭区间, 初始值仍为左闭右开*/
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;  
        while (left < right) {
            int mid = right + (left - right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
