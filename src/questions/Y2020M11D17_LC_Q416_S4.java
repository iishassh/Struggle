package questions;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 给定一个 只包含正整数 的 非空 数组, 是否可以将这个数组分割成 两个子集, 使得两个子集的元素和相等
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11]
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * 时间复杂度: O(n * target), n 是数组的长度, target 是整个数组的元素和的一半
 * <p>
 * 空间复杂度: O(target), target 是整个数组的元素和的一半
 * <p>
 * Optimization of {@link Y2020M11D17_LC_Q416_S3}
 */
public class Y2020M11D17_LC_Q416_S4 {

    public static void main(String args[]) {
        Y2020M11D17_LC_Q416_S4 instance = new Y2020M11D17_LC_Q416_S4();

        // new int[]{1, 5, 11, 5}
        // new int[]{1, 2, 3, 5}
        // new int[]{9, 5}
        // new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        //         100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}

        System.out.println(instance.canPartition(new int[]{1, 5, 11, 5}));
    }

    /**
     * 优化空间
     * <p>
     * 事实上, 在 dp[i][j] 的计算过程中
     * 只参考上一行 dp[i - 1][j'], j' ∈ [0, j] 的结果
     * 因此可以使用滚动数组, 从后向前赋值
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int length = nums.length;
        if (length < 2 || (sum & 1) != 0) {
            return false;
        }

        int half = sum >> 1;

        boolean[] dp = new boolean[half + 1];

        // 对 目标数值等于0 的情况进行初始化, 使得状态方程成立
        // 事实上, 相当于对 未选择任何元素 这种情况进行初始化, 数值在考虑数组的第 1 个元素时被参考
        dp[0] = true;

        // 不再从数组的第 2 个元素开始遍历
        // 不需要再单独考虑第 1 个元素
        // 直接从数组的第 1 个元素开始遍历, 在考虑第 1 个元素时, 实际上是参考 未选择任何元素 情况下的值
        for (int num : nums) {
            // 使用滚动数组, 必须从后向前赋值
            // 当 j 从前向后赋值时, dp[i][j] 的值 可能会覆盖 dp[i - 1][(j + 1) - num] 的值
            // 当 j 从后向前赋值时, dp[i][j] 的值 不可能覆盖 dp[i - 1][(j - 1) - num] 的值
            for (int j = half; j >= num; j--) {
                // 状态方程依然是: dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]] (j >= nums[i])
                // 此时 dp[j] 本身的值就是 "上一行 dp[i - 1][j]" 的值
                dp[j] = dp[j] || dp[j - num];

                // 错误地覆盖了 "dp[i - 1][j]" 的值
                // dp[j] = dp[j - num];
            }
        }
        return dp[half];
    }
}
