package org.testingground.mower.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testTurnLeft() {
        assertEquals(Orientation.W, Orientation.N.turnLeft());
        assertEquals(Orientation.S, Orientation.W.turnLeft());
        assertEquals(Orientation.E, Orientation.S.turnLeft());
        assertEquals(Orientation.N, Orientation.E.turnLeft());
    }

    @Test
    void testTurnRight() {
        assertEquals(Orientation.E, Orientation.N.turnRight());
        assertEquals(Orientation.S, Orientation.E.turnRight());
        assertEquals(Orientation.W, Orientation.S.turnRight());
        assertEquals(Orientation.N, Orientation.W.turnRight());
    }
}
