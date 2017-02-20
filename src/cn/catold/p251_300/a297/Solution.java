package cn.catold.p251_300.a297;

import cn.catold.util.BaseSolution;
import cn.catold.util.TreeNode;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://discuss.leetcode.com/category/375/serialize-and-deserialize-binary-tree
 */
public class Solution extends BaseSolution {

    @Override
    public Object run() {
        Codec codec = new Codec();
        TreeNode treeNode = TreeNode.create();
        String str = codec.serialize(treeNode);
        TreeNode res = codec.deserialize(str);

        return null;
    }
}
