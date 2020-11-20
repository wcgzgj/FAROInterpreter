package top.faroz.util;

import top.faroz.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TreeUtil
 * @Description 和树的操作相关的工具类
 * @Author FARO_Z
 * @Date 2020/11/20 下午8:07
 * @Version 1.0
 **/
public class TreeUtil {
    /**
     * 广度优先，打印二叉树
     * @param root
     */
    public static void BFS(TreeNode root) {
        if (root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
                if (i==size-1) System.out.print(tmp.val);
                else System.out.print(tmp.val+",");
            }
            System.out.println("]");
        }
    }
}
