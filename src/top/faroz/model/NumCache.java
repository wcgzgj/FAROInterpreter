package top.faroz.model;

/**
 * @ClassName NumCache
 * @Description 数据区，存储和计算相关的数据
 * 并包括和计算相关的式子
 * @Author FARO_Z
 * @Date 2020/11/16 下午3:06
 * @Version 1.0
 **/
public class NumCache {
    public static NumCache instance=new NumCache();

    public static NumCache getInstance() {
        return instance;
    }
}
