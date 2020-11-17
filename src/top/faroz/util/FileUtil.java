package top.faroz.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 下午1:19
 * @Version 1.0
 **/
public class FileUtil {
    /**
     * 读取文件，这里会将指令与文件名保持一致
     * @param name
     * @return
     */
    public static List<String> readFile(String name) {
        String fileName = "src/instruction_file/" + name+".txt";
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)){
            while (true) {
                String line = br.readLine();
                if (null==line) {
                    break;
                }
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
