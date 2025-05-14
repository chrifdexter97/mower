package org.testingground.mower.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testingground.mower.model.*;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrchestrationServiceImplTest {

    private FileService fileService;
    private MowerService mowerService;
    private OrchestrationServiceImpl orchestrationService;

    @BeforeEach
    void setUp() {
        fileService = mock(FileService.class);
        mowerService = mock(MowerService.class);
        orchestrationService = new OrchestrationServiceImpl(fileService, mowerService);
    }

    @Test
    void testExecuteScenarioProcessedAndPositionsReturned() throws IOException {

        Mower initialMower = mock(Mower.class);
        Mower finalMower = mock(Mower.class);
        Position finalPosition = mock(Position.class);

        List<Move> moves = List.of(Move.A, Move.G, Move.D);

        OrchestrationScenario scenario = new OrchestrationScenario(initialMower, moves);
        when(fileService.processFile("test.txt")).thenReturn(List.of(scenario));


        when(mowerService.executeMove(initialMower, Move.A)).thenReturn(finalMower);
        when(mowerService.executeMove(finalMower, Move.G)).thenReturn(finalMower);
        when(mowerService.executeMove(finalMower, Move.D)).thenReturn(finalMower);

        when(finalMower.getPosition()).thenReturn(finalPosition);
        when(finalPosition.toString()).thenReturn("3 3 E");

        when(mowerService.findAll()).thenReturn(List.of(finalMower));


        String result = orchestrationService.execute("test.txt");

        verify(fileService).processFile("test.txt");
        verify(mowerService).save(finalMower);
        verify(mowerService).findAll();
        assertEquals("3 3 E", result);
    }

    @Test
    void testExecuteEmptyScenarioListReturnsEmptyString() throws IOException {
        when(fileService.processFile("empty.txt")).thenReturn(List.of());
        when(mowerService.findAll()).thenReturn(List.of());

        String result = orchestrationService.execute("empty.txt");

        assertEquals("", result);
        verify(mowerService).findAll();
    }
}