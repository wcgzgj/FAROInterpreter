package top.faroz.test;

import com.singularsys.jep.functions.Str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName StringArrayUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/21 上午12:24
 * @Version 1.0
 **/
public class StringArrayUtil {
    public static void main(String[] args) {
        String[] arr={"abc","ppp","def","ppp","kkk"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list,arr);
        List<String> remove = new ArrayList<>();
        remove.add("ppp");
        remove.add("kkk");
        list.removeAll(remove);
        String[] strings = list.toArray(new String[list.size()]);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
