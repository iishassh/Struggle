package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val, 你需要 原地 移除所有数值等于 val 的元素, 并返回移除后数组的新长度
 * <p>
 * 不要使用额外的数组空间, 你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * 元素的顺序可以改变, 你不需要考虑数组中超出新长度后面的元素
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * Reference: https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Different implementation of {@link Y2020M09D03_LC_Q27_S2}
 */
public class Y2020M09D03_LC_Q27_S3 {

    public static void main(String args[]) {
        Y2020M09D03_LC_Q27_S3 instance = new Y2020M09D03_LC_Q27_S3();

        // int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        int[] nums = new int[]{1, 2};
        // int[] nums = new int[]{1};

        System.out.println(instance.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    // 元素的顺序可以改变
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
                continue;
            }
            i++;
        }
        return len;
    }
}
