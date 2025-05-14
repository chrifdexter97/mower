package org.testingground.mower.service;

import java.io.IOException;

public interface OrchestrationService {
    /**
     * Executes the Mower Scenario specified in file given in param.
     * @param filePath the path to the file.
     * @return String formatted response containing final positions
     * of Mowers.
     * @throws IOException if file not found or corrupted.
     */
    String execute(String filePath) throws IOException;
}
