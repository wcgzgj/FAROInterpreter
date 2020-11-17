package top.faroz.test;

import top.faroz.util.NumUtil;
import top.faroz.util.Stack;

/**
 * @ClassName SimpleCalculatorTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 下午7:55
 * @Version 1.0
 **/
public class SimpleCalculatorTest {
    public static void main(String[] args) {
        String func = "(12+2)*3+4/2)";// 44
        System.out.println(getResult(func));
    }

    public static int getResult(String s) {
        Stack<Integer> stack = new Stack<>();
        int num=0;
        String sign="+";

        int jump=0;//jump是为了保证递归结束以后
        for (int i = 0; i < s.length(); i++) {
            i+=jump;
            jump=0;

            String stringAtI = String.valueOf(s.charAt(i));
            //如果是数字
            if (NumUtil.isNum(stringAtI)) {
                num=num*10+Integer.parseInt(stringAtI);
            }
            //如果遇到运算符
            //之前的数字和符号就要存进栈中
            //&& tmp!=" " 是为了保证不会判断空格
            if ( (!NumUtil.isNum(stringAtI) && stringAtI!=" " &&
                    !"(".equals(stringAtI) && !")".equals(stringAtI) )|| i==s.length()-1) {
                switch (sign) {
                    case "+":
                        stack.push(num); break;
                    case "-":
                        stack.push(-num); break;
                    case "*":
                        Integer pre1 = stack.pop();
                        stack.push(pre1*num);
                        break;
                    case "/":
                        Integer pre2 = stack.pop();
                        stack.push(pre2/num);
                        break;
                }
                //更新符号
                sign=stringAtI;
                //数字清零
                num=0;
            }

            /**
             * 在进行递归之前，要保证算式末尾不会是左括号，这要在传入之前进行判断
             * 如果
             * 是最左边的括号，还要保证左括号后面跟着一个基础运算符号（保证是赋值，或者是运算操作） -> 这是解释器要注意的事项
             */
            //如果是左括号，进行递归
            if ("(".equals(stringAtI)) {
                // System.out.println(s.substring(i+1));
                num=getResult(s.substring(i+1));
                /**
                 * !注意：虽然退出了递归
                 * 但是父层的i还是递归之前的i，
                 * 这就会导致运算结果错误无
                 *
                 * 所以我就引入了jump来解决此问题
                 */
                jump=s.substring(i).indexOf(")");
            }

            //如果是右括号，返回栈中值
            if (")".equals(stringAtI)) {
                int res=0;
                while (!stack.isEmpty()) {
                    res+=stack.pop();
                }
                // System.out.println(res+num);
                return res+num;
            }
        }
        int res=0;
        while (!stack.isEmpty()) {
            res+=stack.pop();
        }
        return res;
    }
}
