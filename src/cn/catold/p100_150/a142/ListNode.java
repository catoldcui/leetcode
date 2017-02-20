package cn.catold.p100_150.a142;

/**
 * Created by catold on 16/02/2017.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
