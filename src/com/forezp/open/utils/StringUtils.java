package com.forezp.open.utils;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字符串操作类
 * Created by forezp on 2015/12/28.
 */
public class StringUtils {




    /**
     * 将字符串保存到文件中
     *
     * @param desc
     *            : 要保存的字符 Path:保存文件的绝对路
     *
     */
    public static void saveStringToFile(String desc, String absPath) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        File file = null;
        if (desc == null || "".equals(desc.trim())) {
            return;
        }
        if (absPath == null || "".equals(absPath.trim())) {
            return;
        }
        try {
            file = new File(absPath);
            if (file != null && file.exists()) {
                return;
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(desc.getBytes());
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

