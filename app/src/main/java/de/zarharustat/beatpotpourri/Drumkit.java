package de.zarharustat.beatpotpourri;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class Drumkit {
    private SoundPool samplePlayer;
    private int sndIDKick;
    private int sndIDSnare;
    private int sndIDHiHat;
    private int sndIDTom01;
    private int sndIDTom02;
    private int sndIDTom03;
    private int sndIDTrash01;
    private int sndIDTrash02;
    private int sndIDTrash03;

    public Drumkit(Context ctx){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes playerAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .build();

            samplePlayer = new SoundPool.Builder()
                    .setMaxStreams(9)
                    .setAudioAttributes(playerAttributes)
                    .build();
        }else{
            samplePlayer = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);
        }

        sndIDHiHat = samplePlayer.load(ctx, R.raw.hi_hat, 1);
        sndIDSnare = samplePlayer.load(ctx, R.raw.snare, 1);
        sndIDKick = samplePlayer.load(ctx, R.raw.kick_01, 1);

        sndIDTom01 = samplePlayer.load(ctx, R.raw.windows_sound, 1);
        sndIDTom02 = samplePlayer.load(ctx, R.raw.tom_04, 1);
        sndIDTom03 = samplePlayer.load(ctx, R.raw.tom_05, 1);

        sndIDTrash01 = samplePlayer.load(ctx, R.raw.trash_01, 1);
        sndIDTrash02 = samplePlayer.load(ctx, R.raw.trash_05, 1);
        sndIDTrash03 = samplePlayer.load(ctx, R.raw.trash_10, 1);
    }

    public void hitHiHat(float left, float right){
        System.out.println("hitHiHat");
        samplePlayer.play(sndIDHiHat, left, right, 0, 0, 1);
    }
    public void hitKick(float left, float right){
        System.out.println("hitKick");
        samplePlayer.play(sndIDKick, left, right, 0, 0, 1);
    }
    public void hitSnare(float left, float right){
        System.out.println("hitSnare");
        samplePlayer.play(sndIDSnare, left, right, 0, 0, 1);
    }
    public void hitTom01(float left, float right){
        System.out.println("hitTom1");
        samplePlayer.play(sndIDTom01, left, right, 0, 0, 1);
    }
    public void hitTom02(float left, float right){
        System.out.println("hitTom2");
        samplePlayer.play(sndIDTom02, left, right, 0, 0, 1);
    }
    public void hitTom03(float left, float right){
        System.out.println("hitTom3");
        samplePlayer.play(sndIDTom03, left, right, 0, 0, 1);
    }
    public void hitTrash01(float left, float right){
        System.out.println("hitTrash1");
        samplePlayer.play(sndIDTrash01, left, right, 0, 0, 1);
    }
    public void hitTrash02(float left, float right){
        System.out.println("hitTrash2");
        samplePlayer.play(sndIDTrash02, left, right, 0, 0, 1);
    }
    public void hitTrash03(float left, float right){
        System.out.println("hitTrash3");
        samplePlayer.play(sndIDTrash03, left, right, 0, 0, 1);
    }
    public int getHiHat(){
        return sndIDHiHat;
    }
    public int getKick(){
        return sndIDKick;
    }
    public int getSnare(){
        return sndIDSnare;
    }
    public int getTom01(){
        return sndIDTom01;
    }
    public int getTom02(){
        return sndIDTom02;

    }
    public int hgetTom03(){
        return sndIDTom03;

    }
    public int getTrash01(){
        return sndIDTrash01;

    }
    public int getTrash02(){
        return sndIDTrash02;

    }
    public int getTrash03(){
        return sndIDTrash03;
    }

    public void playDrum(int drum, Volume vol){
        if(!vol.off()){
            samplePlayer.play(drum, vol.left(), vol.right(), 0, 0, 1);
        }
    }




    public void releasePlayer() {
        samplePlayer.release();
    }
}
