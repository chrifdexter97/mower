package org.testingground.mower.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testingground.mower.service.OrchestrationService;

import java.io.IOException;


import static org.mockito.Mockito.*;

class OrchestrationControllerImplTest {

    private OrchestrationService orchestrationService;
    private OrchestrationControllerImpl controller;

    @BeforeEach
    void setUp() {
        orchestrationService = mock(OrchestrationService.class);
        controller = new OrchestrationControllerImpl(orchestrationService);
    }

    @Test
    void testExecuteSuccessfulExecution() throws IOException {
        String filePath = "I_DO_EXIST.txt";
        String expectedResult = "1 3 N 5 1 E";

        when(orchestrationService.execute(filePath)).thenReturn(expectedResult);

        controller.execute(filePath);

        verify(orchestrationService).execute(filePath);
    }

    @Test
    void testExecuteThrowsIOExceptionLogsWarning() throws IOException {
        String filePath = "I_DO_NOT_EXIST.txt";

        when(orchestrationService.execute(filePath)).thenThrow(new IOException("File not found"));

        controller.execute(filePath);

        verify(orchestrationService).execute(filePath);
    }
}
