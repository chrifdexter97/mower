package org.testingground.mower.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.testingground.mower.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTest {

    private final FileServiceImpl fileService = new FileServiceImpl();

    @Test
    void testProcessFileValidInput(@TempDir File tempDir) throws IOException {

        File inputFile = new File(tempDir, "input.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("5 5\n");
            writer.write("1 2 N\n");
            writer.write("GAGAGAGAA\n");
        }

        List<OrchestrationScenario> scenarios = fileService.processFile(inputFile.getAbsolutePath());

        assertEquals(1, scenarios.size());

        OrchestrationScenario scenario = scenarios.get(0);
        Mower mower = scenario.mower();
        Position position = mower.getPosition();

        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Orientation.N, position.getOrientation());

        List<Move> moves = scenario.moves();
        assertEquals(9, moves.size());
        assertEquals(Move.G, moves.get(0));
        assertEquals(Move.A, moves.get(1));
    }

    @Test
    void testProcessFileMissingCommandsLine(@TempDir File tempDir) throws IOException {

        File inputFile = new File(tempDir, "input_incomplete.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("5 5\n");
            writer.write("3 3 E\n");
        }

        assertThrows(IOException.class, () -> fileService.processFile(inputFile.getAbsolutePath()));
    }
}
