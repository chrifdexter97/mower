package org.testingground.mower.controller;

import org.testingground.mower.service.OrchestrationService;

import java.io.IOException;
import java.util.logging.Logger;

public class OrchestrationControllerImpl implements OrchestrationController {
    /**
     * orchestration service instance that will take
     * care of the logic of processing the mower instructions
     * file.
     */
    private final OrchestrationService orchestrationService;
    /**
     * a minimalist logging solution for printing the result on console.
     */
    private final Logger logger = Logger.getLogger("output");

    /**
     * Class Constructor.
     * @param orchestrationServiceParam an OrchestrationService instance.
     */
    public OrchestrationControllerImpl(
            final OrchestrationService orchestrationServiceParam) {
        this.orchestrationService = orchestrationServiceParam;
    }

    /**
     * The method that launches the process of mower scenarios
     * orchestration starting with a path to a file.
     * @param filePath a path to mower instructions file.
     */
    public void execute(final String filePath) {

        try {
            String result = orchestrationService.execute(filePath);
            logger.info(result);
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }


}
