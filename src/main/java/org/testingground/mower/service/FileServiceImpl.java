package org.testingground.mower.service;

import org.testingground.mower.model.Lawn;
import org.testingground.mower.model.Move;
import org.testingground.mower.model.OrchestrationScenario;
import org.testingground.mower.model.Position;
import org.testingground.mower.model.Orientation;
import org.testingground.mower.model.Mower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    /**
     * Takes a filepath, Parses it and extract
     * a list of Mower OrchestrationScenarios.
     * @param filePath the path to the file.
     * @return list of OrchestrationScenarios.
     * @throws IOException if the file is missing or corrupted.
     */
    @Override
    public List<OrchestrationScenario> processFile(
            final String filePath) throws IOException {

        List<OrchestrationScenario> orchestrationScenarios = new ArrayList<>();

        try (BufferedReader reader
                     = new BufferedReader(new FileReader(filePath))) {

            Lawn lawn = parseLawn(reader.readLine());

            String positionLine;

            while ((positionLine = reader.readLine()) != null) {

                Position position = parsePosition(positionLine);

                Mower mower = new Mower(position, lawn);

                String commandsLine = reader.readLine();
                if (commandsLine == null) {
                    throw new IOException(
                            "Expected a command line after position line: "
                                    + positionLine);
                }

                List<Move> moves = parseMoves(commandsLine);

                orchestrationScenarios
                        .add(new OrchestrationScenario(mower, moves));
            }
        }

        return orchestrationScenarios;
    }

    private Lawn parseLawn(final String line) {
        String[] parts = line.split(" ");
        return new Lawn(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    private Position parsePosition(final String line) {
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Orientation orientation = Orientation.valueOf(parts[2]);
        return new Position(x, y, orientation);
    }

    private List<Move> parseMoves(final String line) {
        List<Move> moves = new ArrayList<>();

        for (char c : line.toCharArray()) {
            moves.add(Move.fromChar(c));
        }
        return moves;
    }

}
