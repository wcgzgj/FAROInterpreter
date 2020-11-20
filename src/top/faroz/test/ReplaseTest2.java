package top.faroz.test;

/**
 * @ClassName ReplaseTest2
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/20 下午4:12
 * @Version 1.0
 **/
public class ReplaseTest2 {
    public static void main(String[] args) {
        String s = "+";
        s = s.replaceAll("\\+", " " +s+ " ");
        System.out.println(s);
    }
}
