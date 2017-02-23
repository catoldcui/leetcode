package cn.catold.p001_050.a021;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.*;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((ListNode) o1).val - ((ListNode) o2).val;
            }
        });

        while (l1 != null) {
            queue.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue.add(l2);
            l2 = l2.next;
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode head = queue.poll();
        ListNode pre = head;
        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;
        }
        pre.next = null;

        return head;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) return l1;
        if (l2 != null && l1 == null) return l2;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        node.next = (l1 != null) ? l1 : l2;// Append the remaining elements in the longer list
        return head.next;
    }


    @Override
    public Object run() {
        System.out.println(mergeTwoLists1(ListNode.create(3, 1, 2), ListNode.create(4, 3, 3)));
        return null;
    }
}
