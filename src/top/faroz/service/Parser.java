package top.faroz.service;

import sun.security.provider.certpath.SunCertPathBuilder;
import top.faroz.domain.TreeNode;
import top.faroz.util.ParserUtil;
import top.faroz.util.TextAreaUtil;
import top.faroz.util.TreeUtil;

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
        //3.判断语法树  -> 这里针对每一种错误，都会返回不同的错误提示
        if (!TreeUtil.isElemNumOK(root,strs)) {
            TextAreaUtil.customError("括号数或格式错误");
            return;
        }
        if (!TreeUtil.isUnleafsOK(root)) {
            TextAreaUtil.customError("运算符或格式错误");
            return;
        }
        if (!TreeUtil.isLeafsOK(root)) {
            TextAreaUtil.customError("函数格式错误");
            return;
        }
        if (!TreeUtil.isGiveValOK(root)) {
            TextAreaUtil.customError("赋值错误，被赋值对象必须是参数");
            return;
        }
        //4.通过正确的语法树，进行计算，或者是赋值






    }
}
