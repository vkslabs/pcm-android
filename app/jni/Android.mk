
LOCAL_PATH:=$(call my-dir)


include $(CLEAR_VARS)

LOCAL_LDLIBS  := -llog
APP_STL := gnustl_static

#module name and source files
LOCAL_MODULE := adpcm

#LOCAL_C_INCLUDES := adpcmlib.h
LOCAL_SRC_FILES := pcm_jni.c adpcmlib.cpp





include $(BUILD_SHARED_LIBRARY)