package com.liu.climb.update.increment;

/**
 * @author pd_liu 2018年2月7日
 *         <p>
 *         DiffUtils 生成差异包工具类
 *         </p>
 */

public class DiffUtils {

    static {//导入libhello.so 文件。 这里面只写hello就可以
        System.loadLibrary("diff");
    }

    /**
     * native方法 比较路径为oldPath的apk与newPath的apk之间差异，并生成patch包，存储于patchPath
     * <p>
     * 返回：0，说明操作成功
     *
     * @param oldApkPath 示例:/sdcard/old.apk
     * @param newApkPath 示例:/sdcard/new.apk
     * @param patchPath  示例:/sdcard/xx.patch
     * @return
     */
    public static native String genDiff(String oldApkPath, String newApkPath, String patchPath);
}
