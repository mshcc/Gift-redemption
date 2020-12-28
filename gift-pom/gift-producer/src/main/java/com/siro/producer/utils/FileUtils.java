package com.siro.producer.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author mshcc
 * @date 2020/12/24
 */
public class FileUtils {

    /**
     * TODO 文件上传后的保存路径，打包放到服务器上时记得更改
     */
//    public static final String FILE_PATH="D:\\code\\idea_workplace\\gift\\Gift-redemption\\src\\main\\resources\\picture";

    public static final String FILE_PATH="/home/mshcc/gift/pictures";
    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @return
     */
    public static boolean upload(MultipartFile file, String path){



        //使用原文件名
//        String realPath = path + "/" + fileName;

        File dest = new File(path);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);

            return true;
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
}