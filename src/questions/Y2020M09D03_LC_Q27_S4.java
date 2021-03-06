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
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Different implementation of {@link Y2020M09D03_LC_Q27_S3}
 */
public class Y2020M09D03_LC_Q27_S4 {

    public static void main(String args[]) {
        Y2020M09D03_LC_Q27_S4 instance = new Y2020M09D03_LC_Q27_S4();

        // int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        int[] nums = new int[]{1, 2};
        // int[] nums = new int[]{1};

        System.out.println(instance.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    // 元素的顺序可以改变
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (val == nums[start]) {
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}
