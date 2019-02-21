package de.zarharustat.beatpotpourri;

import android.content.Context;
import android.media.SoundPool;

public class SimpleBeat extends Thread {

    private final Drumkit itsDrumkit;
    private final int itsBpm;
    private int lengthInMsOneBeat = 0;
    private long lenthInMsOneSixeenth =0;
    private TimeSignature itsTimeSignatur;

    int fourth01, fourth02, fourth03, fourth04;
    int eighth01, eighth02, eighth03, eighth04, eighth05, eighth06, eighth07, eighth08;
    int sixteenth01, sixteenth02, sixteenth03, sixteenth04, sixteenth05, sixteenth06, sixteenth07, sixteenth08,
            sixteenth09, sixteenth10, sixteenth11, sixteenth12, sixteenth13, sixteenth14, sixteenth15, sixteenth16;

    private int[] timeStampsForSixtennth;
    private int lastSixteenthIndx;

    public SimpleBeat(Drumkit kit, int bpm, TimeSignature ts){
        itsBpm = bpm;
        itsDrumkit = kit;
        itsTimeSignatur = ts;

        lengthInMsOneBeat = Math.round(60/itsBpm * 1000);

        lenthInMsOneSixeenth = lengthInMsOneBeat / ts.getNumberOfSixteenth();
       // int roundingDiff = lengthInMsOneBeat - (ts.getNumberOfSixteenth() * lenthInMsOneSixeenth);
        timeStampsForSixtennth = new int[ts.getNumberOfSixteenth()];
        timeStampsForSixtennth[0] = 0;
        lastSixteenthIndx = ts.getNumberOfSixteenth() - 1;

        timeStampsForSixtennth[lastSixteenthIndx] = lengthInMsOneBeat;
       //


    }

    @Override
    public void run() {
        super.run();

        for(int i = 0; i < lastSixteenthIndx; i++){
            if(i % 4 == 0)
                itsDrumkit.hitKick(0,0.7f);

            if(i % 4 == 0)
                itsDrumkit.hitSnare(0.6f,0);

            if(i % 2 == 0)
                itsDrumkit.hitHiHat(1,1);

            try {
                sleep(lenthInMsOneSixeenth);
            }catch(InterruptedException ex){
                if (Thread.currentThread().isInterrupted())
                    return;
            }
        }


    }
}
