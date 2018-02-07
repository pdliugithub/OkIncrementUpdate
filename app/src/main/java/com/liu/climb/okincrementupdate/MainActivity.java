package com.liu.climb.okincrementupdate;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liu.climb.update.increment.DiffUtils;
import com.liu.climb.update.increment.PatchUtils;
import com.liu.climb.update.util.ApkUtils;
import com.liu.climb.update.util.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author pd_liu 2018年2月7日
 *         <p>
 *         增量更新功能样式展示
 *         </p>
 *         <p>
 *         一、测试“增量更新功能”步骤：
 *         1、找到--》assets文件夹下的：app-release-old.apk文件发送到手机中进行安装
 *         2、运行所安装的app，按照从上到下依次执行：拷贝--》生成差量包--》合并差量包--》更新APP （ps: 执行顺序之间间隔至少等待几秒时间）
 *         [没执行一个步骤，也可以打开手机文件管理找到--》存储管理，找到--》mwh文件夹内的资源变化，进而可以直观的查看到每一个操作所做的大致效果]
 *         </p>
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        tv.setText(PatchUtils.patch2());
    }

    /**
     * 拷贝资源
     * @param view click view
     */
    public void copy(View view) {
        FileUtils.createDirs();
        copyFileFromAsset(Constant.OLD_APK_PATH, Constant.OLD_APK_NAME);//首先把assets下的apk文件复制到sdcard上
        copyFileFromAsset(Constant.NEW_APK_PATH, Constant.NEW_APK_NAME);//首先把assets下的apk文件复制到sdcard上
    }

    /**
     * 生成差量包
     * @param view click view.
     */
    public void diff(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = DiffUtils.genDiff(Constant.OLD_APK_PATH, Constant.NEW_APK_PATH, Constant.PATCH_FILE);
                Log.e(TAG, "result: " + s);
            }
        }).start();
    }

    /**
     * OldFile + patchFile = newFile.
     * @param view click view.
     */
    public void patch(View view) {
        String oldfile = Constant.OLD_APK_PATH;
        //2.合并得到最新版本的APK文件
        String newfile = Constant.OLD_2_NEW_APK;
        String patchfile = Constant.PATCH_FILE;
        PatchUtils.patch(oldfile, newfile, patchfile);
    }

    /**
     * 安装合并后的安装包
     * @param view click view.
     */
    public void update(View view) {
        Toast.makeText(MainActivity.this, "您正在进行无流量更新", Toast.LENGTH_SHORT).show();
        ApkUtils.installApk(MainActivity.this, Constant.OLD_2_NEW_APK);
    }

    private void copyFileFromAsset(String filePath, String assetName) {
        AssetManager assetManager = this.getAssets();
        try {
            File file = new File(filePath);
            if (!file.exists()) {//文件不存在才复制
                InputStream in = assetManager.open(assetName);
                OutputStream out = new FileOutputStream(filePath);
                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                out.flush();
                out.close();
            } else {
                Log.e(TAG, "当前文件已经存在" + assetName);
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getString();
}
