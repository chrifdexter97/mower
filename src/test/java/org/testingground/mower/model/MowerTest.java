package org.testingground.mower.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MowerTest {

    private Lawn lawn;
    private Position position;
    private Mower mower;


    @BeforeEach
    void setUp() {
        lawn = mock(Lawn.class);
        position = mock(Position.class);
        mower = new Mower(position, lawn);
    }

    @Test
    void testMoveForwardInsideLawn() {
        Position newPosition = mock(Position.class);
        when(position.nextForward()).thenReturn(newPosition);
        when(lawn.isInside(newPosition)).thenReturn(true);

        mower.moveForward();

        verify(position).nextForward();
        verify(lawn).isInside(newPosition);
        verify(position).moveTo(newPosition);
    }

    @Test
    void testMoveForwardOutsideLawn() {
        Position newPosition = mock(Position.class);
        when(position.nextForward()).thenReturn(newPosition);
        when(lawn.isInside(newPosition)).thenReturn(false);

        mower.moveForward();

        verify(position).nextForward();
        verify(lawn).isInside(newPosition);
        verify(position, never()).moveTo(any());
    }

    @Test
    void testTurnLeft() {
        mower.turnLeft();
        verify(position).turnLeft();
    }

    @Test
    void testTurnRight() {
        mower.turnRight();
        verify(position).turnRight();
    }

    @Test
    void testGetPosition() {
        assertEquals(mower.getPosition(), position);
    }
}
