package org.testingground.mower.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveTest {

    @Test
    void testFromCharPositive(){
        assertEquals(Move.G, Move.fromChar('G'));
        assertEquals(Move.A, Move.fromChar('A'));
        assertEquals(Move.D, Move.fromChar('D'));
    }

    @Test
    void testFromCharNegative(){
        assertThrows(IllegalArgumentException.class, () -> Move.fromChar('Z'));
    }
}
