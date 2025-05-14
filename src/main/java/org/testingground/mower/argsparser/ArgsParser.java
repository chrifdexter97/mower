package org.testingground.mower.argsparser;

import com.beust.jcommander.JCommander;

import java.util.Optional;
import java.util.logging.Logger;

public class ArgsParser {
    /**
     * args instance.
     */
    private final Args args = new Args();

    /**
     * Minimalist Logger instance.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * extracts file path for args String array.
     * @param argv args array.
     * @return an Optional value of filePath string.
     */
    public Optional<String> extractFilePath(final String[] argv) {
        JCommander jc = new JCommander(args);

        try {
            jc.parse(argv);
        } catch (Exception e) {
            logger.warning(e.getMessage());
            jc.usage();
            return Optional.empty();
        }

        if (args.isHelp()) {
            jc.usage();
            return Optional.empty();
        }

        return Optional.of(args.getFilePath());
    }
 }
