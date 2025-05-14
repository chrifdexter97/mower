package org.testingground.mower.service;


import org.testingground.mower.model.Move;
import org.testingground.mower.model.Mower;
import org.testingground.mower.model.OrchestrationScenario;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class OrchestrationServiceImpl implements OrchestrationService {
    /**
     * FileService instance.
     */
    private final FileService fileService;
    /**
     * MowerService instance.
     */
    private final MowerService mowerService;

    /**
     * Class Constructor.
     * @param fileServiceParam FileService instance.
     * @param mowerServiceParam MowerService instance.
     */
    public OrchestrationServiceImpl(
            final FileService fileServiceParam,
            final MowerService mowerServiceParam) {
        this.fileService = fileServiceParam;
        this.mowerService = mowerServiceParam;
    }
    /**
     * Executes the Mower Scenario specified in file given in param.
     * @param filePath the path to the file.
     * @return String formatted response containing final positions
     * of Mowers.
     * @throws IOException if file not found or corrupted.
     */
    @Override
    public String execute(final String filePath) throws IOException {
        List<OrchestrationScenario> orchestrationScenarios
                = fileService.processFile(filePath);
        for (OrchestrationScenario orchestrationScenario
                : orchestrationScenarios) {
            executeScenario(orchestrationScenario);
        }
        return buildPostionsString();
    }

    private void executeScenario(
            final OrchestrationScenario orchestrationScenario) {
        Mower mower = orchestrationScenario.mower();
        List<Move> moves = orchestrationScenario.moves();
        for (Move move : moves) {
            mower = mowerService.executeMove(mower, move);
        }
        mowerService.save(mower);
    }

    private String buildPostionsString() {
        return mowerService
                .findAll()
                .stream().map(mower -> mower.getPosition().toString())
                .collect(Collectors.joining(" "));
    }
}
