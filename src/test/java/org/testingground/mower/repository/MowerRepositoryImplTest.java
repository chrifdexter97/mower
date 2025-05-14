package org.testingground.mower.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testingground.mower.model.Mower;
import org.testingground.mower.model.Orientation;
import org.testingground.mower.model.Position;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MowerRepositoryImplTest {

    private MowerRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new MowerRepositoryImpl();
    }

    @Test
    void testSaveAndFindAll() {
        Mower mower1 = mock(Mower.class);
        Mower mower2 = mock(Mower.class);

        repository.save(mower1);
        repository.save(mower2);

        List<Mower> mowers = repository.findAll();
        assertEquals(2, mowers.size());
        assertTrue(mowers.contains(mower1));
        assertTrue(mowers.contains(mower2));
    }

    @Test
    void testIsPositionOccupiedTrue() {
        Position position = new Position(1, 2, Orientation.N);
        Mower mower = mock(Mower.class);
        when(mower.getPosition()).thenReturn(position);

        repository.save(mower);

        Position checkPosition = new Position(1, 2, Orientation.E);
        assertTrue(repository.isPositionOccupied(checkPosition));
    }

    @Test
    void testIsPositionOccupiedFalse() {
        Position position = new Position(1, 2, Orientation.S);
        Mower mower = mock(Mower.class);
        when(mower.getPosition()).thenReturn(position);

        repository.save(mower);

        Position otherPosition = new Position(2, 3, Orientation.N);
        assertFalse(repository.isPositionOccupied(otherPosition));
    }
}