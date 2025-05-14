package org.testingground.mower.repository;

import org.testingground.mower.model.Mower;
import org.testingground.mower.model.Position;

import java.util.List;

public interface MowerRepository {
    /**
     * persists a Mower instance.
     * @param mower Mower instance to Persist.
     */
    void save(Mower mower);

    /**
     * Returns all persisted Instances of Mowers.
     * @return List of Mowers
     */
    List<Mower> findAll();

    /**
     * Check if a Mower is at a given Position in params.
     * @param position The position to test.
     * @return Whether the position is occupied or not.
     */
    boolean isPositionOccupied(Position position);
}
