package cn.longyt.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class FileTools {

    /**
     * 复制文件
     * @param srcPath
     * @param destPath
     * @throws IOException
     */
    public static void copyFile(String srcPath, String destPath) throws IOException {
        FileUtils.copyFile(new File(srcPath), new File(destPath));
    }

    /**
     * 写文件
     * @param filePath
     * @param datas
     * @throws IOException
     */
    public static void writeFile(String filePath, Collection<?> datas) throws IOException {
        FileUtils.writeLines(new File(filePath), datas);
    }
}
