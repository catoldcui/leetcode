package cn.catold.p251_300.a297;

import cn.catold.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        build(root, sb);

        if (sb.charAt(0) == ',') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",null");
            return;
        }

        sb.append(",").append(node.val);

        build(node.left, sb);
        build(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return rebuild(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode rebuild(LinkedList<String> strs) {
        if (strs.size() == 0) {
            return null;
        }

        String temp = strs.poll();
        if ("null".equals(temp)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(temp));

        node.left = rebuild(strs);
        node.right = rebuild(strs);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));