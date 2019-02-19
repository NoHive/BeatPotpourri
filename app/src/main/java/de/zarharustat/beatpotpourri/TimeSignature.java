package de.zarharustat.beatpotpourri;

public class TimeSignature {
    public enum DenominatorTyp{
        half,
        four,
        eight,
    }

    private int itsNumerator;
    private DenominatorTyp itsDenominator;

    public TimeSignature(int numerator, DenominatorTyp denominator){
        itsNumerator = numerator;
        itsDenominator = denominator;
    }

    public static TimeSignature THREE_FOUR = new TimeSignature(3, DenominatorTyp.four);
    public static TimeSignature FOUR_FOUR = new TimeSignature(4, DenominatorTyp.four);
    public static TimeSignature SIX_EIGHT = new TimeSignature(6, DenominatorTyp.eight);
}
