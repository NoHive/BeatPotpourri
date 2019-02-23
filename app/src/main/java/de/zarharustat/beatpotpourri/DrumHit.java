package de.zarharustat.beatpotpourri;

public class DrumHit {
    private int itsDrum;
    private Drumkit itsKit;
    private Volume itsVol;
    public DrumHit(Drumkit kit, int drum, Volume vol){
        itsDrum = drum;
        itsKit = kit;
        itsVol = vol;
    }

    public void play(){
        if(! itsVol.off()){
            itsKit.playDrum(itsDrum, itsVol);
        }
    }
}
