cmake_minimum_required(VERSION 3.18.1)
project(image_processing_util_jni C)

add_library(image_processing_util_jni SHARED src/restored_native_v8.c)

# NDK 提供: liblog (android/log.h), libandroid (native_window / bitmap)
find_library(log-lib log)
find_library(android-lib android)

target_link_libraries(image_processing_util_jni ${log-lib} ${android-lib})
