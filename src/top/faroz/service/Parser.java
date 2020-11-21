package top.faroz.service;

import sun.security.provider.certpath.SunCertPathBuilder;
import top.faroz.domain.TreeNode;
import top.faroz.util.ParserUtil;
import top.faroz.util.TextAreaUtil;

/**
 * @ClassName FunctionCalculate
 * @Description 用来处理函数，
 * 包含的是处理函数字符串的核心算法
 * 将函数表示的值计算、输出出去
 * @Author FARO_Z
 * @Date 2020/11/17 上午10:03
 * @Version 1.0
 **/
public class Parser {
    /**
     * 解释器要实现两个基本功能：
     *  1. 赋值  -> 需要借助额外的数据空间   model.numCache
     *  2. 计算  -> 需要借助栈或者其他数据结构
     */
    //(:= a 3)
    public static void parseFunc(String func) {
        //1.创建字符流
        String[] strs = ParserUtil.toToken(func);
        //2.获得语法树
        TreeNode root = ParserUtil.buildTree(strs);
        //3.判断语法树
        /**
         * 语法树判断要有以下几个方面：
         *  1.语法树的元素个数，要和token中，去除括号后的元素个数一模一样
         *  2.语法树的非叶子节点，必须全部是运算符
         *  3.语法树的叶子节点，必须是参数，或者是数值
         *  4.如果语法树的根节点是"="，那么，根节点的左子树必须只能是一个元素，且该元素必须是一个参数（可以被赋值）
         */
        /*

            语法树的判断

         */

        //4.通过正确的语法树，进行计算，或者是赋值



    }
}
