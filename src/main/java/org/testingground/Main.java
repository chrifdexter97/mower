package org.testingground;

import org.testingground.mower.argsparser.ArgsParser;
import org.testingground.mower.controller.OrchestrationController;
import org.testingground.mower.controller.OrchestrationControllerImpl;
import org.testingground.mower.repository.MowerRepository;
import org.testingground.mower.repository.MowerRepositoryImpl;

import org.testingground.mower.service.FileService;
import org.testingground.mower.service.FileServiceImpl;
import org.testingground.mower.service.MowerServiceImpl;
import org.testingground.mower.service.OrchestrationServiceImpl;

import java.util.Optional;

public class Main {
    /**
     * The argsParser instance used to extract args typed
     * by the user notably the path to file.
     */
    private final ArgsParser argsParser;

    /**
     * The OrchestrationController instance that
     * will handle the overall program logic starting
     *  with the file path.
     */
    private final OrchestrationController orchestrationController;

    /**
     * A parameterized Constructor used mainly to facilitate unit testing.
     * It takes Three params; an ArgsParser,a fileService and a MowerRepository
     * @param argsParserParam an ArgsParser Instance
     * @param fileService a FileService Instance
     * @param mowerRepository a MowerRepository Instance
     */
    public Main(final ArgsParser argsParserParam,
                final FileService fileService,
                final MowerRepository mowerRepository) {
        this.argsParser = argsParserParam;

        this.orchestrationController = new OrchestrationControllerImpl(
                new OrchestrationServiceImpl(
                        fileService,
                        new MowerServiceImpl(
                              mowerRepository
                        )
                )
        );
    }

    /**
     * the default Main class Constructor.
     * @param args the args array.
     */
    public static void main(final String[] args) {

        Main main = new Main(
                new ArgsParser(),
                new FileServiceImpl(),
                new MowerRepositoryImpl()
        );

        main.run(args);
    }

    /**
     * A run method that launches the main logic of the app.
     * @param args the args array
     */
    public void run(final String[] args) {
        Optional<String> filePath = argsParser.extractFilePath(args);
        filePath.ifPresent(orchestrationController::execute);
    }

}
