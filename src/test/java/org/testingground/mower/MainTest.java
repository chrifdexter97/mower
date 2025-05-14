package org.testingground.mower;

import org.junit.jupiter.api.Test;
import org.testingground.Main;
import org.testingground.mower.argsparser.ArgsParser;
import org.testingground.mower.controller.OrchestrationController;
import org.testingground.mower.repository.MowerRepository;
import org.testingground.mower.service.FileService;

import java.util.Optional;

import static org.mockito.Mockito.*;

class MainTest {

    @Test
    void runShouldCallExecuteWhenFilePathIsPresent() {

        ArgsParser argsParser = mock(ArgsParser.class);
        when(argsParser.extractFilePath(any())).thenReturn(Optional.of("file.txt"));

        FileService fileService = mock(FileService.class);
        MowerRepository mowerRepository = mock(MowerRepository.class);

        OrchestrationController orchestrationController = mock(OrchestrationController.class);

        Main main = new Main(argsParser, fileService, mowerRepository) {
            @Override
            public void run(String[] args) {
                orchestrationController.execute("file.txt");
            }
        };


        main.run(new String[]{"--file", "file.txt"});

        verify(orchestrationController).execute("file.txt");
    }
}
