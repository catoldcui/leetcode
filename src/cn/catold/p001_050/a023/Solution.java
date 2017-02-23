package cn.catold.p001_050.a023;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((ListNode) o1).val - ((ListNode) o2).val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                queue.add(temp);
                temp = temp.next;
            }
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

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int length = lists.length;
        while (length != 1) {
            for (int i = 1; i < length; i += 2) {
                lists[i / 2] = mergeTwoLists1(lists[i - 1], lists[i]);
            }

            if (length % 2 == 1) {
                lists[length / 2] = lists[length - 1];
            }
            length = length / 2 + length % 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
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
        ListNode[] l = new ListNode[]{
            null, ListNode.create(4, 3, 3),
            ListNode.create(3, 1, 2), ListNode.create(4, 3, 3),
            ListNode.create(3, 1, 2), ListNode.create(4, 3, 3)
        };
        System.out.println(mergeKLists1(l));
        return null;
    }
}
