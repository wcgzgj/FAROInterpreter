package top.faroz.model;

import com.singularsys.jep.functions.Str;
import com.sun.org.apache.xpath.internal.functions.FuncContains;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumCache
 * @Description 数据缓冲区，存储变量及其值
 * 其中维护一个 HashMap
 * @Author FARO_Z
 * @Date 2020/11/16 下午3:06
 * @Version 1.0
 **/
public class DataCache {
    private static HashMap<String,Float> map=new HashMap<>();

    /**
     * 更新键值对
     * 有一样的，更新
     * 没有一样的，添加
     * @param k
     * @param v
     */
    public static void update(String k,Float v) {
        if (map.containsKey(k)) map.replace(k,v);
        else map.put(k,v);
    }

    /**
     * 清空维护的HashMap，方便下一次使用
     */
    public static void clear() {
        map.clear();
    }

    public static boolean contains(String k) {
        if (map.containsKey(k)) return true;
        return false;
    }

    public static float getValue(String k) {
        return map.get(k);
    }




}
