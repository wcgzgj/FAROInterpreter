package top.faroz.test;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;
import com.singularsys.jep.parser.Node;

/**
 * @ClassName jepTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/17 下午1:54
 * @Version 1.0
 **/
public class jepTest {
    public static void main(String[] args) {
        Jep jep = new Jep();
        try {
            Node parse = jep.parse("x * 2--3");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            jep.setVariable("x",i);
            try {
                System.out.println(jep.evaluate());
            } catch (EvaluationException e) {
                e.printStackTrace();
            }
        }
    }
}
