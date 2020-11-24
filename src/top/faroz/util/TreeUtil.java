package top.faroz.util;

import top.faroz.domain.TreeNode;

import java.util.*;

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

    /**
     * 获得所有叶子节点
     * @param root
     * @return
     */
    public static List<TreeNode> getLeafs(TreeNode root) {
        if (root==null) return null;
        List<TreeNode> list = new ArrayList<>();
        getLeafs(root,list);
        return list;
    }

    private static void getLeafs(TreeNode root,List<TreeNode> list) {
        if (root.left==null && root.right==null) {
            list.add(root);
            return;
        }
        if (root.left!=null) getLeafs(root.left,list);
        if (root.right!=null) getLeafs(root.right,list);
    }

    /**
     * 获取所有非叶子节点
     * @param root
     * @return
     */
    public static List<TreeNode> getUnLeafs(TreeNode root) {
        if (root==null) return null;
        List<TreeNode> list = new ArrayList<>();
        getUnLeafs(root,list);
        return list;
    }

    private static void getUnLeafs(TreeNode root,List<TreeNode> list) {
        if (root.left==null && root.right==null) return;
        list.add(root);
        if (root.left!=null) getUnLeafs(root.left,list);
        if (root.right!=null) getUnLeafs(root.right,list);
    }


    //=================================下面是对语法树正确性的判断===============================
    /**
     * 语法树判断要有以下几个方面：
     *  1.语法树的元素个数，要和token中，去除括号后的元素个数一模一样
     *  2.语法树的非叶子节点，必须全部是运算符
     *  3.语法树的叶子节点，必须是参数，或者是数值
     *  4.如果语法树的根节点是"="，那么，根节点的左子树必须只能是一个元素，且该元素必须是一个参数（可以被赋值）
     */

    /**
     * 一套组合拳下来，判断语法树是不是正确的
     * @param root
     * @param strs
     * @return
     */
    public static boolean isTreeOK(TreeNode root,String[] strs) {
        return isElemNumOK(root,strs) &&
                isUnleafsOK(root) &&
                isLeafsOK(root) &&
                isGiveValOK(root);
    }


    /**
     * 1.语法树的元素个数，要和token中，去除括号后的元素个数一模一样
     * @param root 树根节点
     * @param strs token流  -> token在使用前，一定要记得去除所有的括号
     * @return
     */
    public static boolean isElemNumOK(TreeNode root,String[] strs) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,strs);
        List<String> remove = new ArrayList<>();
        remove.add("(");
        remove.add(")");
        //删除所有的括号
        list.removeAll(remove);

        //获取语法树的节点个数
        if (root==null && strs.length!=0) return false;
        int treeNodeNum=getLeafs(root).size()+getUnLeafs(root).size();
        //如果二者数量不相等，说明输入的函数是错误的
        if (treeNodeNum!=list.size()) return false;
        return true;
    }

    /**
     * 2.语法树的非叶子节点，必须全部是运算符
     * @param root
     * @return
     */
    public static boolean isUnleafsOK(TreeNode root) {
        List<TreeNode> unLeafs = getUnLeafs(root);
        for (TreeNode unLeaf : unLeafs) {
            if (!WordUtil.isOperator(unLeaf.val)) return false;
        }
        return true;
    }

    /**
     * 3.语法树的叶子节点，必须是参数，或者是数值
     * 这里用排除法  如果不是 括号  或者基础运算符，就算OK
     * 这样，虽然有些符号不能被筛选出来（如 & # -> 其实可以被作为参数）
     * 但是，能够保证输入的参数可以不止一个字符长度
     * @param root
     * @return
     */
    public static boolean isLeafsOK(TreeNode root) {
        List<TreeNode> leafs = getLeafs(root);
        for (TreeNode leaf : leafs) {
            if (WordUtil.isOperator(leaf.val) ||
                WordUtil.isBracket(leaf.val))
                return false;
        }
        return true;
    }

    /**
     * 4.如果语法树的根节点是"="，那么，根节点的左子树必须只能是一个元素，且该元素必须是一个参数（可以被赋值）
     * @param root
     * @return
     */
    public static boolean isGiveValOK(TreeNode root) {
        //首先要保证，根节点的值是赋值符号
        //如果根节点值不是赋值，那么直接放过了
        if (!root.val.equals("=")) return true;
        //左节点不能是空
        if (root.left==null) return false;
        //左节点必须是叶子节点
        if (root.left.left!=null || root.left.right!=null) return false;
        //左节点必须是可赋值的对象
        if (WordUtil.isBracket(root.left.val) ||
            WordUtil.isOperator(root.left.val) ||
            WordUtil.isNum(root.left.val)) return false;
        //右节点如果为空，那么赋值没有任何意义，判断为错误
        if (root.right==null) return false;
        return true;
    }
}
