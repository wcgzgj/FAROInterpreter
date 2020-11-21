package top.faroz.test;

import top.faroz.domain.TreeNode;
import top.faroz.exception.CalculateWrongException;
import top.faroz.exception.DivideZeroException;
import top.faroz.exception.NoParamException;
import top.faroz.service.Parser;
import top.faroz.util.ParserUtil;
import top.faroz.util.TreeUtil;

import javax.xml.transform.Source;

/**
 * @ClassName BuildWordTreeTest
 * @Description 语法树构建测试
 * @Author FARO_Z
 * @Date 2020/11/20 下午8:11
 * @Version 1.0
 **/
public class BuildWordTreeTest {
    public static void main(String[] args) {
        // String str = "(+(*b 2)(/4 a))";
        // String str = "(=a (*b (+ 6 3)))";
        // String str = "(+b (%7 2)";
        String str = "(+(/10 3) (* (+ 3 1) (- 5 3)))";
        String[] strs = ParserUtil.toToken(str);
        TreeNode treeNode = ParserUtil.buildTree(strs);
        TreeUtil.BFS(treeNode);

        System.out.println("\n");

        System.out.println(TreeUtil.isTreeOK(treeNode,strs));


        //经过测试,语法树构建正确
        //递归计算值完全能够胜任
        try {
            System.out.println(ParserUtil.calculateTreeValue(treeNode));
        } catch (DivideZeroException e) {
            System.out.println(e.getMessage());
        } catch (CalculateWrongException e) {
            System.out.println(e.getMessage());
        } catch (NoParamException e) {
            System.out.println(e.getMessage());
        }

    }
}
