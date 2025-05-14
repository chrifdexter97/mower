package org.testingground.mower.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testNextForwardNorthFacing() {
        Position start = new Position(2, 2, Orientation.N);
        Position next = start.nextForward();
        assertEquals(2, next.getX());
        assertEquals(3, next.getY());
    }

    @Test
    void testNextForwardSouthFacing() {
        Position start = new Position(2, 2, Orientation.S);
        Position next = start.nextForward();
        assertEquals(2, next.getX());
        assertEquals(1, next.getY());
    }

    @Test
    void testNextForwardEastFacing() {
        Position start = new Position(2, 2, Orientation.E);
        Position next = start.nextForward();
        assertEquals(3, next.getX());
        assertEquals(2, next.getY());
    }

    @Test
    void testNextForwardWestFacing() {
        Position start = new Position(2, 2, Orientation.W);
        Position next = start.nextForward();
        assertEquals(1, next.getX());
        assertEquals(2, next.getY());
    }

    @Test
    void testToString(){
        Position position = new Position(2, 2, Orientation.N);
        assertEquals(position.toString(), position.getX()
                + " " + position.getY() + " " + position.getOrientation());
    }

    @Test
    void testTurnLeftAndRight() {
        Position p = new Position(0, 0, Orientation.N);
        p.turnRight();
        assertEquals(Orientation.E, p.getOrientation());
        p.turnLeft();
        assertEquals(Orientation.N, p.getOrientation());
    }

    @Test
    void testMoveTo() {
        Position p = new Position(1, 1, Orientation.S);
        Position newPos = new Position(2, 2, Orientation.S);
        p.moveTo(newPos);
        assertEquals(2, p.getX());
        assertEquals(2, p.getY());
    }
}
