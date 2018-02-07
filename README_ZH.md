# OkIncrementUpdate
    Increment Update Android

***

[English](/README.md)  |||  [中文](/README_ZH.md)

[![My logo](https://avatars2.githubusercontent.com/u/18112904?s=400&u=0c9b3829937d677b3aaaf2783747fadbfaf1c33d&v=4)]

### 效果图1、2、3

![拷贝、分包]](/gifs/gif_30.gif "gif")

![合并]](/gifs/gif_50.gif)

![更新]](/gifs/gif_end.gif)

## 实现如效果图步骤
    1、安装
[Apk下载](/apks/app-release.apk)

    2、按照效果图步骤即可实现效果图样式

# 增量更新的原理
    增量更新的原理非常简单，简单的说就是通过某种算法找出新版本和旧版本不一样的地方（这个过程也叫做差分），
    然后将不一样的地方抽取出来形成所谓的更新补丁（patch），也称之为差分包。
    客户端在检测到更新的时候，只需要下载差分包到本地，
    然后将差分包合并至本地的安装包，形成新版本的安装包，文件校验通过后再执行安装即可。
    本地的安装包通过提取当前已安装应用的apk得到。

# 使用:

    Step1:将其添加到您的根build.gradle存储库的末尾：
    ```
    allprojects {
         	repositories {
         		...
         		maven { url 'https://jitpack.io' }
         	}
         }
    ```


     Step 2. 添加依赖关系.
     ```
     dependencies {
          	  compile 'com.github.pdliugithub:OkIncrementUpdate:v1.0' // v1.0 ---> 修改为最近版本号.
          }
     ```


[![Medal](https://jitpack.io/v/pdliugithub/OkIncrementUpdate.svg)](https://jitpack.io/#pdliugithub/OkIncrementUpdate)


##### 代码使用帮助:
        ```
        1、生成差量包.
        //上一个版本路径 \ 当前版本路径 \ 当前版本与上一个版本生成差量包存放的路径.
        DiffUtils.genDiff(String oldApkPath, String newApkPath, String patchPath);

        ```

        2、合并差量包.
        //已经安装的版本路径 \ 合并差量包后的存放路径 \ 差量包路径.
        PatchUtils.patch(String oldApkPath, String newApkPath, String patchPath);


***


