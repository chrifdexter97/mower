package org.testingground.mower.model;

public enum Orientation {
    /**
     * "Nord".
     */
    N,
    /**
     * "East".
     */
    E,
    /**
     * "Sud".
     */
    S,
    /**
     * "West".
     */
    W;

    /**
     * Handles making a 90-degree turn the left.
     * @return an updated Orientation instance.
     */
    public Orientation turnLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    /**
     * Handles making a 90-degree turn the right.
     * @return an updated Orientation instance.
     */
    public Orientation turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }
}
