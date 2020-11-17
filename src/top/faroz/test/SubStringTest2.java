package top.faroz.test;

/**
 * @ClassName SubStringTest2
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/17 上午9:33
 * @Version 1.0
 **/
public class SubStringTest2 {
    public static void main(String[] args) {
        String s = "(zbcd)";
        //subString 包含头，但是不包含尾
        s=s.substring(1);
        s=s.substring(0,s.length()-1);
        System.out.println(s);
    }
}
