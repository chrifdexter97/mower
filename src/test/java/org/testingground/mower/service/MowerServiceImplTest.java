package org.testingground.mower.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testingground.mower.model.Move;
import org.testingground.mower.model.Mower;
import org.testingground.mower.model.Position;
import org.testingground.mower.repository.MowerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class MowerServiceImplTest {

    private MowerRepository mowerRepository;
    private MowerServiceImpl mowerService;

    private Mower mower;
    private Position currentPosition;
    private Position nextPosition;

    @BeforeEach
    void setUp() {
        mowerRepository = mock(MowerRepository.class);
        mowerService = new MowerServiceImpl(mowerRepository);

        mower = mock(Mower.class);
        currentPosition = mock(Position.class);
        nextPosition = mock(Position.class);

        when(mower.getPosition()).thenReturn(currentPosition);
        when(currentPosition.nextForward()).thenReturn(nextPosition);
    }

    @Test
    void testSave() {
        mowerService.save(mower);
        verify(mowerRepository).save(mower);
    }

    @Test
    void testFindAll() {
        List<Mower> mowers = new ArrayList<>();
        mowers.add(mower);
        when(mowerRepository.findAll()).thenReturn(mowers);

        List<Mower> result = mowerService.findAll();
        assertSame(mowers, result);
    }

    @Test
    void testExecuteMoveTurnLeft() {
        Mower result = mowerService.executeMove(mower, Move.G);
        verify(mower).turnLeft();
        assertSame(mower, result);
    }

    @Test
    void testExecuteMoveTurnRight() {
        Mower result = mowerService.executeMove(mower, Move.D);
        verify(mower).turnRight();
        assertSame(mower, result);
    }

    @Test
    void testExecuteMoveMoveForwardWhenNotOccupied() {
        when(mowerRepository.isPositionOccupied(nextPosition)).thenReturn(false);

        Mower result = mowerService.executeMove(mower, Move.A);
        verify(mower).moveForward();
        assertSame(mower, result);
    }

    @Test
    void testExecuteMoveDoesNotMoveWhenPositionOccupied() {
        when(mowerRepository.isPositionOccupied(nextPosition)).thenReturn(true);

        Mower result = mowerService.executeMove(mower, Move.A);
        verify(mower, never()).moveForward();
        assertSame(mower, result);
    }
}
