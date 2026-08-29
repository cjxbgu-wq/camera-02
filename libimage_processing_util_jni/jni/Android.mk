LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := image_processing_util_jni
LOCAL_SRC_FILES := ../src/restored_native_v8.c
LOCAL_LDFLAGS   := -shared
LOCAL_LDLIBS    := -landroid -llog
# Note: original .so also uses libc malloc/free/memcpy (imported via PLT GOT
# 0xa938/0xa940/0xa950/0xa958). NDK links libc automatically, no extra LDLIBS needed.
include $(BUILD_SHARED_LIBRARY)
