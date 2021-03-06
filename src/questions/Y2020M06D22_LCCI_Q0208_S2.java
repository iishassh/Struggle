package questions;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * <p>
 * Solution: Fast & Slow Pointer
 * <p>
 * Reference: https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(N), 其中 N 为链表中节点的数目
 * 在最初判断快慢指针是否相遇时, slow 指针走过的距离不会超过链表的总长度
 * 随后寻找入环点时, 走过的距离也不会超过链表的总长度
 * 因此, 总的执行时间为 O(N) + O(N) = O(N)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M06D22_LCCI_Q0208_S2 {

    public static void main(String args[]) {
        Y2020M06D22_LCCI_Q0208_S2 instance = new Y2020M06D22_LCCI_Q0208_S2();
        // 1
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;

        // 2
        // ListNode head = new ListNode(1);
        // head.next = head;

        // 3
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = head;
        System.out.println(instance.detectCycle(head));
    }

    // 错误的解法
    // (ListNode fast = head.next; ListNode slow = head;) 并不是预先设想的快指针走两步, 慢指针走一步
    // public ListNode detectCycle(ListNode head) {
    //     ListNode fast = head.next;
    //     ListNode slow = head;
    //     while (fast != slow && fast.next != null && fast.next.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //
    //     if (fast.next == null || fast.next.next == null) {
    //         return null;
    //     }
    //
    //     fast = head;
    //     while (fast != slow) {
    //         fast = fast.next;
    //         slow = slow.next;
    //     }
    //     return fast;
    // }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "node-" + this.hashCode() + ": " + this.val;
        }
    }
}
