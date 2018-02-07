package com.liu.climb.okincrementupdate;

import com.liu.climb.update.util.FileUtils;

/**
 * @author pd_liu on 2018/2/7.
 *         <p>
 *         常量类
 *         </p>
 */

public class Constant {

    public static final String FILE_PATH = FileUtils.getExternalStoragePath();
    public static final String OLD_APK_NAME = "app-release-old.apk";
    public static final String OLD_APK_PATH = FILE_PATH + OLD_APK_NAME;


    public static final String NEW_APK_NAME = "app-release-new.apk";
    public static final String NEW_APK_PATH = FILE_PATH + NEW_APK_NAME;



    // patch包存储路径 + 名称
    public static final String PATCH_FILE = FILE_PATH+ "diff.patch";

    //合成包路径+ 名称
    public static final String OLD_2_NEW_APK =FILE_PATH + "Old2New.apk";
}
