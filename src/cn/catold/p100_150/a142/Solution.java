package cn.catold.p100_150.a142;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Solution extends BaseSolution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        boolean res = false;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                res = true;
                break;
            }
        }

        if (!res) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    @Override
    public Object run() {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        head1.next = head2;
        head2.next = head2;

        ListNode res = detectCycle(head1);
        System.out.println(res);
        return null;
    }
}
