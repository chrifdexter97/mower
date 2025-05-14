package org.testingground.mower.model;

public class Mower {
    /**
     * the Lawn surface on which the Mower moves.
     */
    private final Lawn lawn;
    /**
     * the position of the Mower.
     */
    private final Position position;

    /**
     * The class Constructor.
     * @param startPosition the initial position.
     * @param lawnParam the lawn definition.
     */
    public Mower(final Position startPosition, final Lawn lawnParam) {
        this.position = startPosition;
        this.lawn = lawnParam;
    }

    /**
     * Handles moving The Mower one-step Forward.
     */
    public void moveForward() {
        Position newPosition = position.nextForward();
        if (lawn.isInside(newPosition)) {
            position.moveTo(newPosition);
        }
    }

    /**
     * Handles turning the Mower 90-degree to the left.
     */
    public void turnLeft() {
        position.turnLeft();
    }

    /**
     * Handles turning the Mower 90-degree to the right.
     */
    public void turnRight() {
        position.turnRight();
    }

    /**
     * getter for the position of the mower.
     * @return mower Position.
     */
    public Position getPosition() {
        return position;
    }


}
