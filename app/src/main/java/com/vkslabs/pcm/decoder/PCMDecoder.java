package com.vkslabs.pcm.decoder;

import android.content.Context;

import java.io.File;

/**
 */

public class PCMDecoder {
    private static final String TAG = PCMDecoder.class.getName();

    static {
        System.loadLibrary("adpcm");
    }

    /**
     *
     * @param inputPath Input file absolute path
     * @param outputPath Output file absolute path. value can be null in which case input file is replaced with the decoded file.
     * @param listener Listener to get progress update
     * @throws Exception Thrown in case the input file is not in ADPCM format.
     */
    public void decode(String inputPath, String outputPath, DecodeListener listener) throws Exception {
        if(outputPath == null) {
            File inputFile = new File(inputPath);
            File file = File.createTempFile("output", null, inputFile.getParentFile());
            String tempPath = file.getAbsolutePath();
            decodeToPCM(inputPath, tempPath, listener);
            createOutputFile(inputPath, tempPath);
        } else {
            decodeToPCM(inputPath, outputPath, listener);
        }
    }

    private void createOutputFile(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        if(outputFile.exists()) {
            inputFile.delete();
            outputFile.renameTo(inputFile);
        }
    }


    private native void decodeToPCM(String inputPath, String outputPath, DecodeListener listener) throws Exception;

    public interface DecodeListener {
        public void updateProgress(int progress);
    }
}
