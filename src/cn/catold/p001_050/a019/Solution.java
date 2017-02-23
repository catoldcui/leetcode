package cn.catold.p001_050.a019;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    ListNode resNode = null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        count(head, n);
        if (resNode == null) {
            return head.next;
        }

        if (resNode.next != null) {
            resNode.next = resNode.next.next;
        }

        return head;
    }

    public int count(ListNode head, int n) {
        if (head.next == null) {
            return 1;
        }

        int curEndIndex = count(head.next, n);
        if (curEndIndex++ == n) {
            resNode = head;
        }

        return curEndIndex;
    }


    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        LinkedList<ListNode> l = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            l.add(0, temp);
            temp = temp.next;
        }

        if (n > l.size()) {
            return head;
        }

        if(n == l.size()) {
            return head.next;
        }

        ListNode res = l.get(n);
        if (res.next != null) {
            res.next = res.next.next;
        }
        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }


    @Override
    public Object run() {
//        Object o = threeSum(new int[]{0, 0, 0, 0});
//        System.out.println(removeNthFromEnd());
        ListNode l = ListNode.create(4);

        System.out.println(removeNthFromEnd1(l, 1));
        System.out.println(removeNthFromEnd1(l, 3));
        return null;
    }
}
