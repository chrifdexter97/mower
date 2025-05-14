package org.testingground.mower.argsparser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArgsParserTest {

    @Test
    void testValidFilePath() {
        ArgsParser parser = new ArgsParser();
        String[] argv = {"--file", "scenario.txt"};

        Optional<String> result = parser.extractFilePath(argv);

        assertTrue(result.isPresent());
        assertEquals("scenario.txt", result.get());
    }

    @ParameterizedTest()
    @MethodSource("invalidArgsProvider")
    void testInvalidArguments(String[] argv) {
        ArgsParser parser = new ArgsParser();
        Optional<String> result = parser.extractFilePath(argv);

        assertTrue(result.isEmpty());
    }

    static Stream<Arguments> invalidArgsProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"--unknown"}),
                Arguments.of((Object) new String[]{"--file"}),
                Arguments.of((Object) new String[]{})
        );
    }

    @Test
    void testHelpFlag() {
        ArgsParser parser = new ArgsParser();
        String[] argv = {"--help"};

        Optional<String> result = parser.extractFilePath(argv);

        assertTrue(result.isEmpty());
    }

}
