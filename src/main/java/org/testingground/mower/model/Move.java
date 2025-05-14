package org.testingground.mower.model;

public enum Move {
    /**
     * "Gauche".
     */
    G,
    /**
     * "Droite".
     */
    D,
    /**
     * "Avant".
     */
    A;

    /**
     * creates a Move instance for a char.
     * @param c char given in param.
     * @return a Move Instance.
     */
    public static Move fromChar(final char c) {
        return switch (c) {
            case 'G' -> G;
            case 'D' -> D;
            case 'A' -> A;
            default -> throw new IllegalArgumentException(
                    "Invalid command: " + c);
        };
    }
}
