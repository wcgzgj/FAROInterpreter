package top.faroz.test;

import top.faroz.domain.TreeNode;
import top.faroz.service.Parser;
import top.faroz.util.ParserUtil;
import top.faroz.util.TreeUtil;

/**
 * @ClassName BuildWordTreeTest
 * @Description 语法树构建测试
 * @Author FARO_Z
 * @Date 2020/11/20 下午8:11
 * @Version 1.0
 **/
public class BuildWordTreeTest {
    public static void main(String[] args) {
        String str = "(+(*b 2)(/4 a))";
        String[] strs = ParserUtil.toToken(str);
        TreeNode treeNode = ParserUtil.buildTree(strs);
        TreeUtil.BFS(treeNode);
    }
}
