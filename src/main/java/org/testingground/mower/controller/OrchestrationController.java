package org.testingground.mower.controller;

public interface OrchestrationController {
    /**
     * The method that launches the process of mower scenarios
     * orchestration starting with a path to a file.
     * @param filePath a path to mower instructions file.
     */
    void execute(String filePath);
}
