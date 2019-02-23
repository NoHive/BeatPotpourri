package de.zarharustat.beatpotpourri;

import android.content.Context;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class SimpleBeat extends Thread {

    private final Drumkit itsDrumkit;
    private final int itsBpm;
    private int lengthInMsOneBeat = 0;
    private long lenthInMsOneSixeenth =0;
    private TimeSignature itsTimeSignatur;

    private int[] timeStampsForSixtennth;
    private int lastSixteenthIndx;
    private HashMap<Integer, Vector<DrumHit>>  sixtennth = new HashMap<>();

    public void addDrumhit(int onSixteenth, DrumHit hit){

        Vector<DrumHit> drumhitsForSixteenth = sixtennth.get(new Integer(onSixteenth));
        if(drumhitsForSixteenth == null){
            drumhitsForSixteenth = new Vector<>();
            sixtennth.put(new Integer(onSixteenth), drumhitsForSixteenth);
        }
        drumhitsForSixteenth.add(hit);

    }

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


            for (int i = 0; i < lastSixteenthIndx; i++) {
                Vector<DrumHit> drumhitsForSixteenth = sixtennth.get(new Integer(i+1));
                Iterator<DrumHit> hits = drumhitsForSixteenth.iterator();
                while ( hits.hasNext()) {
                    DrumHit hit = hits.next();
                    hit.play();
                }

                try {
                    sleep(lenthInMsOneSixeenth);
                } catch (InterruptedException ex) {
                    if (Thread.currentThread().isInterrupted())
                        interrupt();
                }
            }

        itsDrumkit.releasePlayer();


    }
}
