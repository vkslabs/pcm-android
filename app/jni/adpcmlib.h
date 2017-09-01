#import "jni.h"
#include <stdlib.h>

#define NOISE_SHAPING_OFF       0   // flat noise (no shaping)
#define NOISE_SHAPING_STATIC    1   // first-order highpass shaping
#define NOISE_SHAPING_DYNAMIC   2   // dynamically tilted noise based on signal

#define TAG "JNI_PCMDecoder"
#define  log_debug(...)  __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
#define  log_error(...)  __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)

#ifdef __cplusplus
extern "C" {
#endif
    void update_progress(int value);
    static int adpcm_converter (char *infilename, char *outfilename, int flags, int blocksize_pow2, int lookahead);
    void *adpcm_create_context (int num_channels, int lookahead, int noise_shaping, int32_t initial_deltas [2]);
    int adpcm_encode_block (void *p, uint8_t *outbuf, size_t *outbufsize, const int16_t *inbuf, int inbufcount);
    int adpcm_decode_block (int16_t *outbuf, const uint8_t *inbuf, size_t inbufsize, int channels);
    void adpcm_free_context (void *p);
#ifdef __cplusplus
}
#endif