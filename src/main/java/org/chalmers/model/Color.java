package org.chalmers.model;

public enum Color {
    RED(new int[]{255, 0, 0}),
    BLUE(new int[]{0, 0, 255}),
    GREEN(new int[]{0, 255, 0}),
    YELLOW(new int[]{255, 255, 0}),
    PURPLE(new int[]{153, 0, 153}),
    PINK(new int[]{255, 102, 255}),
    TURQUIOSE(new int[]{0, 255, 255}),
    BLACK(new int[]{0, 0, 0}),
    BROWN(new int[]{102, 51, 0}),
    GRAY(new int[]{128, 128, 128});
    //TODO Add more colors :)


    private final int[] RGBValues;
    private static final Color[] vals = values();

    Color(int[] RGBValues) {
        this.RGBValues = RGBValues;
    }

    public int[] getRGBValues() {
        return this.RGBValues;
    }

    public Color next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
