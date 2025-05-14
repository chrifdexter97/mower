package org.testingground.mower.repository;

import org.testingground.mower.model.Mower;
import org.testingground.mower.model.Position;

import java.util.ArrayList;
import java.util.List;

public class MowerRepositoryImpl implements MowerRepository {
    /**
     * List of persisted Mowers. for the purpose of this exercise
     * an in memory list of mowers is enough.
     */
    private final List<Mower> mowers;

    /**
     * Class Constructor.
     */
    public MowerRepositoryImpl() {
        mowers = new ArrayList<>();
    }

    /**
     * persists a Mower instance.
     * @param mower Mower instance to Persist.
     */
    @Override
    public void save(final Mower mower) {
        mowers.add(mower);
    }

    /**
     * Returns all persisted Instances of Mowers.
     * @return List of Mowers
     */
    @Override
    public List<Mower> findAll() {
        return mowers;
    }
    /**
     * Check if a Mower is at a given Position in params.
     * @param position The position to test.
     * @return Whether the position is occupied or not.
     */
    @Override
    public boolean isPositionOccupied(final Position position) {
        return mowers
                .stream()
                .anyMatch(mower -> mower.getPosition().getX() == position.getX()
                && mower.getPosition().getY() == position.getY());
    }

}
