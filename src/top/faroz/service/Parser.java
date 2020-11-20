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
        /*

            语法树的判断

         */

        //4.通过正确的语法树，进行计算，或者是赋值



    }
}
