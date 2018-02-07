#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_liu_climb_okincrementupdate_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_liu_climb_okincrementupdate_MainActivity_getString(JNIEnv *env, jobject instance) {

    // TODO

    std::string hello = "Hello from Cpp";
    return env->NewStringUTF(hello.c_str());
}