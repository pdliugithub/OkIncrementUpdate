package com.liu.climb.update.util;

import android.os.Environment;

import java.io.File;

public class FileUtils {

    public static final String ROOT_DIR = "mwh";

    /**
     * 判断SD卡是否挂载
     */
    public static boolean isSDCardAvailable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取SD下的应用目录
     */
    public static String getExternalStoragePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(ROOT_DIR);
        sb.append(File.separator);
//		/mnt/sdcard/mwh
        return sb.toString();
    }


    /**
     * 创建文件夹
     */
    public static boolean createDirs() {
        StringBuilder sb = new StringBuilder();
        if (isSDCardAvailable()) {
            sb.append(getExternalStoragePath());// /mnt/sdcard/mwh
        }
        String path = sb.toString();

        File file = new File(path.toString());
        System.out.println("path.toString():" + path.toString());
        if (!file.exists() || !file.isDirectory()) {
            return file.mkdirs();
        }
        return true;
    }



}
