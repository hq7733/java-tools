package com.htools.io;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import static com.htools.io.FileUtils.getFileExtension;

/**
 * @author hq
 * @date 2023/8/8
 */
public class BufferedUtils {

    /**
     * 写入文本到文件
     *
     * @param file    File对象
     * @param content 文本内容
     * @return 执行结果
     */
    public static boolean writeString(File file, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 将文件内容写入指定文件
     *
     * @param read  来源文件
     * @param write 接收文件
     * @return 执行结果
     */
    public static boolean writeFile(File read, File write) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(write))) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(read));
            String ss;
            while ((ss = bufferedReader.readLine()) != null) {
                bufferedWriter.write(ss);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 读取文件
     *
     * @param file File对象
     * @return 文件内容
     */
    public static String read(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String ss;
            while ((ss = bufferedReader.readLine()) != null) {
                stringBuffer.append(ss);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存上传的文件
     *
     * @param multipartFile 源文件
     * @param target 目标文件
     * @throws Exception 发生错误
     */
    public static void saveFile(MultipartFile multipartFile, File target) throws Exception {
        String filePrefix = String.valueOf(System.currentTimeMillis());
        String fileSuffix = getFileExtension(multipartFile.getOriginalFilename());
        File tempFile = File.createTempFile(filePrefix, fileSuffix);
        FileCopyUtils.copy(multipartFile.getBytes(), tempFile);
    }
}
