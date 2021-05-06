package questions;

/**
 * https://leetcode-cn.com/problems/video-stitching/
 * 视频拼接
 * <p>
 * 你将会获得一系列视频片段, 这些片段来自于一项持续时长为 T 秒的体育赛事, 这些片段可能有所重叠, 也可能长度不一
 * <p>
 * 视频片段 clips[i] 都用区间进行表示: 开始于 clips[i][0] 并于 clips[i][1] 结束
 * 我们甚至可以对这些片段自由地再剪辑, 例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分
 * <p>
 * 我们需要将这些片段进行再剪辑, 并将剪辑后的内容拼接成覆盖整个运动过程的片段 ([0, T])
 * 返回所需片段的最小数目, 如果无法完成该任务, 则返回 -1
 * <p>
 * 示例 1:
 * 输入: clips = [[0, 2], [4, 6], [8, 10], [1, 9], [1, 5], [5, 9]], T = 10
 * 输出: 3
 * 解释:
 * 我们选中 [0, 2], [8, 10], [1, 9] 这三个片段
 * 然后, 按下面的方案重制比赛片段:
 * 将 [1,9] 再剪辑为 [1, 2] + [2, 8] + [8, 9]
 * 现在我们手上有 [0, 2] + [2, 8] + [8, 10], 而这些涵盖了整场比赛 [0, 10]
 * <p>
 * 示例 2:
 * 输入: clips = [[0, 1], [1, 2]], T = 5
 * 输出: -1
 * 解释: 我们无法只用 [0, 1] 和 [1, 2] 覆盖 [0, 5] 的整个过程
 * <p>
 * 示例 3:
 * 输入: clips = [[0, 1],[6, 8],[0, 2],[5, 6],[0, 4],[0, 3],[6, 7],[1, 3],[4, 7],[1, 4],[2, 5],[2, 6],[3, 4],[4, 5],[5, 7],[6, 9]], T = 9
 * 输出: 3
 * 解释: 我们选取片段 [0, 4], [4, 7] 和 [6 ,9]
 * <p>
 * 示例 4:
 * 输入: clips = [[0, 4], [2, 8]], T = 5
 * 输出: 2
 * 解释: 注意, 你可能录制超过比赛结束时间的视频
 * <p>
 * 提示:
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 * <p>
 * Tags: {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * 时间复杂度: O(T * N), 其中 T 是区间的长度, N 是子区间的数量
 * 对于任意一个前缀区间 [0,i), 我们都需要枚举所有的子区间, 时间复杂度 O(N)
 * 总时间复杂度为 O(T) * O(N) = O(T * N)
 * <p>
 * 空间复杂度: O(T)
 */
public class Y2020M12D19_LC_Q1024_S2 {

    public static void main(String args[]) {
        Y2020M12D19_LC_Q1024_S2 instance = new Y2020M12D19_LC_Q1024_S2();

        // new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10
        // new int[][]{{0, 4}, {2, 8}}, 5
        // new int[][]{{0, 1}, {1, 2}, {4, 5}}, 5
        // new int[][]{{0, 1}, {1, 2}, {4, 5}, {3, 4}, {2, 3}}, 5
        // new int[][]{{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}}, 5

        System.out.println(instance.videoStitching(new int[][]{{2, 8}, {0, 4}}, 5));
    }

    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            dp[i] = clips.length + 1;
        }

        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < clips.length; i++) {
                int clipStart = clips[i][0];
                int clipEnd = clips[i][1];

                if (t > clipStart && t <= clipEnd) {
                    dp[t] = Math.min(dp[t], dp[clipStart] + 1);
                }
            }
        }

        return dp[T] <= clips.length ? dp[T] : -1;
    }
}
