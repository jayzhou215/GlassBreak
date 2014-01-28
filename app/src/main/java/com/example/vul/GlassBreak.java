package com.example.vul;

import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;

/**
 * Created by user on 27.01.14.
 */
public  class GlassBreak
{
    MediaRecorder mRecorder = new MediaRecorder();
    private static final String app_name = "GlassBreaker";
    private static String mFileName;

    public GlassBreak()
    {

    }

    public void do_all()
    {
        startRecording();

    }

    public void startRecording()
    {

        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/"+app_name+".3gp";
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(app_name, "prepare() failed");
        }

        mRecorder.start();
    }

    public void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

}
