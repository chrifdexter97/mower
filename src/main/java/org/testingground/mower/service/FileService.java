package org.testingground.mower.service;

import org.testingground.mower.model.OrchestrationScenario;

import java.io.IOException;
import java.util.List;

public interface FileService {
    /**
     * Takes a filepath, Parses it and extract
     * a list of Mower OrchestrationScenarios.
     * @param filePath the path to the file.
     * @return list of OrchestrationScenarios.
     * @throws IOException if the file is missing or corrupted.
     */
    List<OrchestrationScenario> processFile(String filePath) throws IOException;
}
