package org.testingground.mower.model;

import java.util.List;

public record OrchestrationScenario(Mower mower, List<Move> moves) {
}
