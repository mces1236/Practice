package leetcode.array;

/**
 * Created by chaitanya on 04/07/17.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums  = {2,-3,2,4};

        int pProduct = 1, nProduct = 1, max = Integer.MIN_VALUE, length = nums.length;

        for(int i = 0; i < length; i++) {
            if(pProduct == 0) {
                pProduct = nums[i];
                nProduct = nums[i];
            } else if (pProduct < 0) {
                pProduct = nums[i];
                nProduct *= nums[i];
            } else {
                pProduct *= nums[i];
                nProduct *= nums[i];
            }

            if(pProduct > max) max = pProduct;
            if(nProduct > max) max = nProduct;
        }

        return max;
        System.out.println(max);
    }
}
