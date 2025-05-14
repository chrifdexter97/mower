package org.testingground.mower.model;

public class Position {
    /**
     * x coordination.
     */
    private int x;
    /**
     * y coordination.
     */
    private int y;
    /**
     * Position orientation.
     */
    private Orientation orientation;

    /**
     * Class Constructor.
     * @param xParam x coordination.
     * @param yParam y coordination.
     * @param orientationParam Position orientation.
     */
    public Position(final int xParam,
                    final int yParam,
                    final Orientation orientationParam) {
        this.x = xParam;
        this.y = yParam;
        this.orientation = orientationParam;
    }

    /**
     * Calcuates and returns the next Position
     * if we make a step forward.
     * @return the corresponding Position Instance.
     */
    public Position nextForward() {
        return switch (orientation) {
            case N -> new Position(x, y + 1, orientation);
            case E -> new Position(x + 1, y, orientation);
            case S -> new Position(x, y - 1, orientation);
            case W -> new Position(x - 1, y, orientation);
        };
    }

    /**
     * Handles making a 90-degree turn the left.
     */
    public void turnLeft() {
        this.orientation = this.orientation.turnLeft();
    }

    /**
     * Handles making a 90-degree turn the right.
     */
    public void turnRight() {
        this.orientation = this.orientation.turnRight();
    }

    /**
     * Move To a new position.
     * @param newPosition Position to go to.
     */
    public void moveTo(final Position newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
    }

    /**
     * getter for x value.
     * @return x value.
     */
    public int getX() {
        return x;
    }
    /**
     * getter for y value.
     * @return y value.
     */
    public int getY() {
        return y;
    }

    /**
     * getter for Orientation Value.
     * @return Orientation Value.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * To string override. the idea is to make it
     * close to what is mentioned in the task file.
     * @return String format of the current instance.
     */
    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
