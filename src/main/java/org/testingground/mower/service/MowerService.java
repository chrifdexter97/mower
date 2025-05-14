package org.testingground.mower.service;

import org.testingground.mower.model.Move;
import org.testingground.mower.model.Mower;

import java.util.List;

public interface MowerService {
    /**
     * Save Mower Instance.
     * @param mower instance to save.
     */
    void save(Mower mower);

    /**
     * returns all saved Mower instances.
     * @return list of persisted mowers.
     */
    List<Mower> findAll();

    /**
     * Executes a move on Mower.
     * @param mower mower to apply move on.
     * @param move move to apply.
     * @return Mower instance after move application.
     */
    Mower executeMove(Mower mower, Move move);
}
