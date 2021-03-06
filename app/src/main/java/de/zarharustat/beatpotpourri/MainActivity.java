package de.zarharustat.beatpotpourri;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        sndIDHiHat = samplePlayer.load(this, R.raw.hi_hat, 1);
        sndIDSnare = samplePlayer.load(this, R.raw.snare, 1);
        sndIDKick = samplePlayer.load(this, R.raw.kick_01, 1);

        sndIDTom01 = samplePlayer.load(this, R.raw.windows_sound, 1);
        sndIDTom02 = samplePlayer.load(this, R.raw.tom_04, 1);
        sndIDTom03 = samplePlayer.load(this, R.raw.tom_05, 1);

        sndIDTrash01 = samplePlayer.load(this, R.raw.trash_01, 1);
        sndIDTrash02 = samplePlayer.load(this, R.raw.trash_05, 1);
        sndIDTrash03 = samplePlayer.load(this, R.raw.trash_10, 1);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        samplePlayer.release();
        samplePlayer = null;
        // test
    }

    public void playSamples(View v){
        switch(v.getId()){
            case R.id.btn_sound_hihat:
                playTestSequence(v);
                break;
        }
    }


    SimpleBeat sBeat;
    public void playTestSequence(final View v) {

        if(sBeat == null || (!sBeat.isAlive())) {


            System.out.println("abspielen 1");

            System.out.println("abspielen 1-1");
            Drumkit drum = new Drumkit(v.getContext());
            sBeat = new SimpleBeat(drum, 120, TimeSignature.FOUR_FOUR);
            sBeat.addDrumhit(1, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(3, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(5, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(7, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(9, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(11, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(13, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));
            sBeat.addDrumhit(15, new DrumHit(drum, drum.getHiHat(), Volume.bothFull()));

            sBeat.addDrumhit(1, new DrumHit(drum, drum.getKick(), Volume.bothFull()));
            sBeat.addDrumhit(5, new DrumHit(drum, drum.getKick(), Volume.bothFull()));
            sBeat.addDrumhit(9, new DrumHit(drum, drum.getKick(), Volume.bothFull()));

            sBeat.addDrumhit(9, new DrumHit(drum, drum.getSnare(), Volume.bothFull()));
            sBeat.setRepeats(10);
            sBeat.start();
        }else {
            if (sBeat != null && (!sBeat.isInterrupted()))
                sBeat.interrupt();
        }

//                samplePlayer.play(sndIDSnare, 0, 1, 0, 0, 1);
//                samplePlayer.play(sndIDKick, 0.7F, 0.7F, 0, 0, 1);
//                samplePlayer.play(sndIDHiHat, 1, 0, 0, 0, 1);



        System.out.println("abspielen 2");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
