package org.testingground.mower.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void testIsInsideTrue() {
        Lawn lawn = new Lawn(5, 5);
        assertTrue(lawn.isInside(new Position(3, 3, Orientation.N)));
    }

    @Test
    void testIsInsideFalse() {
        Lawn lawn = new Lawn(5, 5);
        assertFalse(lawn.isInside(new Position(6, 2, Orientation.E)));
        assertFalse(lawn.isInside(new Position(3, 6, Orientation.E)));
        assertFalse(lawn.isInside(new Position(-3, -6, Orientation.E)));
        assertFalse(lawn.isInside(new Position(-3, 4, Orientation.E)));
        assertFalse(lawn.isInside(new Position(-4, 3, Orientation.E)));
        assertFalse(lawn.isInside(new Position(-4, 6, Orientation.E)));
    }
}