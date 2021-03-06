package top.faroz.util;

import top.faroz.domain.Pair;
import top.faroz.domain.TreeNode;
import top.faroz.exception.CalculateWrongException;
import top.faroz.exception.DivideZeroException;
import top.faroz.exception.NoParamException;
import top.faroz.model.DataCache;

/**
 * @ClassName ParserUtil
 * @Description 解释器工具类
 * @Author FARO_Z
 * @Date 2020/11/20 下午3:30
 * @Version 1.0
 **/
public class ParserUtil {
    /**
     * 将字符串转换为token字符流
     * 在token化的时候，自动去除字符头尾的 左右括号
     * @param str
     * @return
     */
    public static String[] toToken(String str) {
        str=str.trim();
        //去除头尾括号
        if (String.valueOf(str.charAt(0)).equals("("))
            str=str.substring(1);
        if (String.valueOf(str.charAt(str.length()-1)).equals(")"))
            str=str.substring(0,str.length()-1);

        //要将字符串中所有这些字符，全部带上前后空格
        //方便使用split函数进行分割
        //这里在匹配的时候，需要进行转义，不然会报错
        String []blocks={"\\+","\\-","\\*","\\/","\\=","\\(","\\)"};

        for (String block : blocks) {
            String dir = " " + block + " ";
            str=str.replaceAll(block,dir);
        }
        //替换以后，还要再来一次去头尾空格
        //不然token化以后，空格会被包含在字符串数组里
        str=str.trim();

        //调用split函数，进行分割
        //要注意忽略空格的个数（使用正则表达式实现）
        return str.split("\\s+");
    }


    /**
     * 构建语法树
     * 构建语法树的时候，要将所有括号都去掉
     * 并通过前序的方式，递归构造语法树
     * @param strs
     * @return
     */
    public static TreeNode buildTree(String[] strs) {
        if (strs.length==0) return null;
        //因为在token化的时候，已经将前后括号全部去掉
        //所以直接取第一个元素即可
        TreeNode root = new TreeNode(strs[0]);

        //第一个数据集闭包
        Pair pair1 = getNextUnion(strs, 0);
        if (pair1==null) return null;//防止空指针异常
        //第二个数据集闭包
        Pair pair2 = getNextUnion(strs, pair1.x2);
        if (pair2==null) return null;

        root.left=buildSubTree(strs,pair1.x1,pair1.x2);
        root.right=buildSubTree(strs,pair2.x1,pair2.x2);

        return root;
    }


    /**
     * 递归构建语法树的枝
     * @param strs token流
     * @param start 左子树开始
     * @param end 左子树结束
     * @return
     */
    private static TreeNode buildSubTree(String[] strs,int start,int end) {
        //如果start==end 说明数据闭包是一个数或者变量
        if (start==end) return new TreeNode(strs[start]);
        //等于的情况不可以排除，因为，数据包可能就是单个单词（而不是括号括起来的）
        if (start>end) {//终止判断
            return null;
        }
        //如果数据闭包是以括号区分的
        if (strs[start].equals("(") && strs[end].equals(")")) {
            start++;
            end--;
        }
        if (start>end) return null;

        //处理完后，如果token正确,start应该是运算符
        //这里就默认当做运算符来操作
        TreeNode root = new TreeNode(strs[start]);

        //第一个数据集闭包
        Pair pair1 = getNextUnion(strs, start);
        if (pair1==null) return null;//防止空指针异常
        //第二个数据集闭包
        Pair pair2 = getNextUnion(strs, pair1.x2);
        if (pair2==null) return null;

        //递归建树枝
        root.left=buildSubTree(strs,pair1.x1,pair1.x2);
        root.right=buildSubTree(strs,pair2.x1,pair2.x2);

        return root;
    }


    /**
     * 获得下一个建树的数据集
     * @param strs token数据流
     * @param currentIndex 在下一个数据集之前的一个下标
     * @return
     */
    private static Pair getNextUnion(String[] strs,int currentIndex) {
        //如果数据集之前的下标是token末尾，说明没了
        if (currentIndex>=strs.length-1) return null;
        //1.括号包裹的情况，即下一个字符是 (
        if ("(".equals(strs[currentIndex+1])) {
            int leftBarcket = currentIndex + 1;
            int rightBucket=getRightBracketIndex(strs,leftBarcket);
            if (leftBarcket<rightBucket) return new Pair(leftBarcket,rightBucket);
        }
        //如果不是用括号包裹的话，那么，下一个
        return new Pair(currentIndex+1,currentIndex+1);
    }

    /**
     * 获取和当前左括号匹配非右括号的下标
     * 也就是说如果当前左括号后面还有一个左括号
     *  那么取得的右括号之前应该还有一个右括号
     * @param strs 传入的token流
     * @param currentIndex 当前  左  括号的下标
     * @return
     */
    private static int getRightBracketIndex(String[] strs,int currentIndex) {
        int res=currentIndex;
        if (res>strs.length-1) return -1;
        Stack<String> stack = new Stack<>();
        stack.push("(");
        while (!stack.isEmpty()) {
            res++;
            if (res>=strs.length) return -1;//都超范围了，那就没什么好说的了
            if (strs[res].equals(")")) stack.pop();
        }
        return res;
    }

    /**
     * 计算语法树的数值
     * 这里传入的树，已经是判断好了的树了
     * 不用再额外判断
     * @param root
     * @return
     */
    public static float calculateTreeValue(TreeNode root)
            throws DivideZeroException, CalculateWrongException, NoParamException {
        //计算，root的值不可是赋值符号
        if (root.val.equals("=")) throw new CalculateWrongException();
        //超过叶子节点 -> 虽然不可能
        if (root==null) return 0;
        //到达叶子节点
        if (root.left==null && root.right==null) {
            if (WordUtil.isNum(root.val)) {

                System.out.println(Float.parseFloat(root.val));
                return Float.parseFloat(root.val);

            } else {//不是数字，则代表是参数
                //如果，之前没有创建过该变量，则报错
                if (!DataCache.contains(root.val)) throw new NoParamException();
                else return DataCache.getValue(root.val);
            }
        }

        String operator = root.val;//运算符号
        float leftVal = calculateTreeValue(root.left);
        float rightVal = calculateTreeValue(root.right);
        switch (operator) {
            case "+":
                return leftVal+rightVal;
            case "-":
                return leftVal-rightVal;
            case "*":
                return leftVal*rightVal;
            case "/":
                //除数不可以是0
                if (rightVal==0) throw new DivideZeroException();
                return leftVal/rightVal;
            default:
                throw new CalculateWrongException();
        }
    }
}
