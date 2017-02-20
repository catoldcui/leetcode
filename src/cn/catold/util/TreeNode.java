package cn.catold.util;

/**
 * Created by catold on 17/02/2017.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode create() {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        return t1;
    }
}
