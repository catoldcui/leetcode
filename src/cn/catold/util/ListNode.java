package cn.catold.util;

/**
 * Created by catold on 20/02/2017.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode temp = next;
        while (temp != null) {
            sb.append(";").append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }

    public static ListNode create(int length) {
        return create(length, 0, 0);
    }

    public static ListNode create(int length, int start) {
        return create(length, start, 0);
    }

    public static ListNode create(int length, int start, int padding) {
        ListNode head = new ListNode(start);
        ListNode pre = head;
        for (int i = 1; i < length; i++) {
            pre.next = new ListNode(start + i * padding);
            pre = pre.next;
        }

        return head;
    }
}
