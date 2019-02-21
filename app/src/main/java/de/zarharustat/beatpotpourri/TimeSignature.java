package de.zarharustat.beatpotpourri;

public class TimeSignature {
    public enum DenominatorTyp{
        half,
        four,
        eight,
        sixteen
    }

    private int itsNumerator;
    private DenominatorTyp itsDenominator;
    private int countsOfSixteenth = 0;

    public TimeSignature(int numerator, DenominatorTyp denominator){
        itsNumerator = numerator;
        itsDenominator = denominator;
        if(denominator == DenominatorTyp.half)
            countsOfSixteenth = numerator * 8;
        if(denominator == DenominatorTyp.four)
            countsOfSixteenth = numerator * 4;
        if(denominator == DenominatorTyp.eight)
            countsOfSixteenth = numerator * 2;
        if(denominator == DenominatorTyp.sixteen)
            countsOfSixteenth = numerator * 1;
    }

    public int getNumberOfSixteenth(){
        return countsOfSixteenth;
    }

    public static TimeSignature THREE_FOUR = new TimeSignature(3, DenominatorTyp.four);
    public static TimeSignature FOUR_FOUR = new TimeSignature(4, DenominatorTyp.four);
    public static TimeSignature SIX_EIGHT = new TimeSignature(6, DenominatorTyp.eight);
}
