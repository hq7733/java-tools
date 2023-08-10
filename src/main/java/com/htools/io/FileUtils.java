package com.htools.io;

import java.io.File;
import java.io.IOException;

/**
 * @author hq
 * @date 2023/8/8
 */
public class FileUtils {
    /**
     * 创建文件
     *
     * @param file File对象
     * @return 执行结果
     */
    public static boolean createFile(File file) {
        try {
            if (file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 批量删除文件
     * @param files Files
     */
    public static void delete(File... files) {
        int length = files.length;
        for (File file : files) {
            file.delete();
        }
    }

    /**
     * 获取文件名
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        if (fileName != null && fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf("."));
        else return "";
    }
}
