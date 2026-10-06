class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int m = nums[i];
            int val = 0;
            while (m > 0) {
                int digit = m % 10;
                val = val + digit;
                m /= 10;
            }
            if (val == i) {
                return i;
            }
        }

        return -1;

    }

}