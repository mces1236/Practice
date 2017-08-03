package leetcode.array;

/**
 * Created by chaitanya on 03/07/17.
 */
public class MaximumSumContiguous {
    public int maxSubArray(int[] nums) {

        if(nums.length == 0) return 0;
        int max = nums[0], cur = nums[0], sum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            cur = nums[i];
            sum = Math.max(cur, (sum + cur));
            max = Math.max(sum, max);
        }

        return max;
    }
}
