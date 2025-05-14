package org.testingground.mower.model;

public class Lawn {
    /**
     * x coordination of the furthest
     * right position of the lawn.
     */
    private final int maxX;

    /**
     * x coordination of the furthest
     * top position of the lawn.
     */
    private final int maxY;

    /**
     * constructor of the class.
     * @param maxXParam max x value of the lawn.
     * @param maxYParam max y value of the lawn.
     */
    public Lawn(final int maxXParam, final int maxYParam) {
        this.maxX = maxXParam;
        this.maxY = maxYParam;
    }

    /**
     * Checks whether a given position is within the lawn.
     * @param position the position to check.
     * @return true if its inside false otherwise.
     */
    public boolean isInside(final Position position) {
        return position.getX() >= 0 && position.getX() <= maxX
                && position.getY() >= 0 && position.getY() <= maxY;
    }
}
