# OkIncrementUpdate
    Increment Update Android

***

[English](/README.md)  |||  [中文](/README_ZH.md)

[![My logo](https://avatars2.githubusercontent.com/u/18112904?s=400&u=0c9b3829937d677b3aaaf2783747fadbfaf1c33d&v=4)]

### Renderings

[![Generate difference package.](/gifs/gif_30.gif)]

[![Synthetic differential package](/gifs/gif_50.gif)]

[![Update app](/gifs/gif_end.gif)]

# Usage:

    Step1:Add it in your root build.gradle at the end of repositories:
    ```
    allprojects {
         	repositories {
         		...
         		maven { url 'https://jitpack.io' }
         	}
         }
    ```


     Step 2. Add the dependency.
     ```
     dependencies {
          	  compile 'com.github.pdliugithub:OkIncrementUpdate:v1.1' // v1.0 ---> The latest version.
          }
     ```

[![Medal](https://jitpack.io/v/pdliugithub/OkIncrementUpdate.svg)](https://jitpack.io/#pdliugithub/OkIncrementUpdate)


##### Code Usage:
        1、Generate difference package.
        //oldApkPath \ newApkPath \ patchPath.
        DiffUtils.genDiff(String oldApkPath, String newApkPath, String patchPath);

        2、Synthetic differential package.
        //oldApkPath \ newApkPath \ patchPath.
        PatchUtils.patch(String oldApkPath, String newApkPath, String patchPath);

