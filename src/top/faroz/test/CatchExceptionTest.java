package top.faroz.test;

import javax.xml.transform.Source;

/**
 * @ClassName CatchExceptionTest
 * @Description 测试异常可不可以通过不同的异常名称进行判断
 * @Author FARO_Z
 * @Date 2020/11/21 下午1:04
 * @Version 1.0
 **/
public class CatchExceptionTest {
    public static void main(String[] args) {
        try {
            exceptionFac(2);
        } catch (Exc1 exc1) {
            System.out.println(exc1.getMessage());
        } catch (Exc2 exc2) {
            System.out.println(exc2.getMessage());
        } catch (Exc3 exc3) {
            System.out.println(exc3.getMessage());
        } catch (Exc4 exc4) {
            System.out.println(exc4.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exceptionFac(int i) throws Exception {
        switch (i) {
            case 1:
                throw new Exc1();
            case 2:
                throw new Exc2();
            case 3:
                throw new Exc3();
            case 4:
                throw new Exc4();
            default:
                throw new Exception();
        }
    }
}

class Exc1 extends Exception {
    public Exc1() {
        super("Exc1");
    }
}

class Exc2 extends Exception {
    public Exc2() {
        super("Exc2");
    }
}

class Exc3 extends Exception {
    public Exc3() {
        super("Exc3");
    }
}

class Exc4 extends Exception {
    public Exc4() {
        super("Exc4");
    }
}
