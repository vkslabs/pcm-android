# pcm-android
ADPCM Encoder and Decoder for Android. 

Android is not capable of playing WAV files in ADPCM format and since most of the Voicemails are encoded in ADPCM, apps will not be able to play them using MediaPlayer.

PCM is uncompressed format whereas Adaptive differential pulse-code modulation (ADPCM) is a compressed using a lossy algorithm. 

This code uses NDK for faster encoding (PCM to ADPCM) and decoding (ADPCM to PCM).
