package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 数组中重复的数字
 * 找出数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
 * 数组中某些数字是重复的, 但不知道有几个数字重复了, 也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字
 * <p>
 * 示例 1:
 * 输入: [2, 3, 1, 0, 2, 5, 3]
 * 输出: 2 或 3
 * <p>
 * Solution: Sort
 * <p>
 * 时间复杂度: O(n * logn)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M12D04_LCOF_Q3_S1 {

    public static void main(String args[]) {
        Y2020M12D04_LCOF_Q3_S1 instance = new Y2020M12D04_LCOF_Q3_S1();

        // new int[]{2, 3, 1, 0, 2, 5, 3}

        System.out.println(instance.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
