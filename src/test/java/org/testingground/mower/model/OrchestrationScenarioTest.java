package org.testingground.mower.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrchestrationScenarioTest {

    @Test
    void orchestrationScenarioConstructor() {
        Lawn lawn = new Lawn(1,2);
        Position position = new Position(1,1,Orientation.N);
        Mower mower = new Mower(position,lawn);
        List<Move> moves = new ArrayList<>();
        moves.add(Move.A);
        moves.add(Move.D);

        assertDoesNotThrow(() -> new OrchestrationScenario(mower,moves));
    }
}
