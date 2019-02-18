package de.zarharustat.beatpotpourri;

import android.media.SoundPool;

public class Simple8thBeat extends Thread {

    private final Drumkit itsDrumkit;
    private final int itsBpm;
    private int lengthInMsOneBeat = 0;

    int fourth01, fourth02, fourth03, fourth04;
    int eighth01, eighth02, eighth03, eighth04, eighth05, eighth06, eighth07, eighth08;
    int sixteenth01, sixteenth02, sixteenth03, sixteenth04, sixteenth05, sixteenth06, sixteenth07, sixteenth08,
            sixteenth09, sixteenth10, sixteenth11, sixteenth12, sixteenth13, sixteenth14, sixteenth15, sixteenth16;

    public Simple8thBeat(Drumkit kit, int bpm){
        itsBpm = bpm;
        itsDrumkit = kit;

        lengthInMsOneBeat = Math.round(60/itsBpm * 1000);

    }

    @Override
    public void run() {
        super.run();


    }
}
