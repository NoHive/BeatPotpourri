package de.zarharustat.beatpotpourri;

public class Volume {
    private float left, right;
    private boolean isOff;
    public Volume(float leftChannel, float rightChannel){
        left = leftChannel;
        right = rightChannel;
    }

    public Volume(){
        isOff = true;
    }

    public float left(){
        return left;
    }

    public float right(){
        return right;
    }

    public boolean off(){
        return isOff;
    }

    public static Volume bothFull(){
        return new Volume(1f, 1f);
    }
    public static Volume justLeft(){
        return new Volume(1f, 0f);
    }
    public static Volume justRight(){
        return new Volume(0f, 1f);
    }
}
