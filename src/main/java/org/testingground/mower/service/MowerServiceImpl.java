package org.testingground.mower.service;

import org.testingground.mower.model.Move;
import org.testingground.mower.model.Mower;
import org.testingground.mower.repository.MowerRepository;

import java.util.List;

public class MowerServiceImpl implements MowerService {
    /**
     * MowerRepository instance.
     */
    private final MowerRepository mowerRepository;

    /**
     * Class Constructor.
     * @param mowerRepositoryParam MowerRepository instance.
     */
    public MowerServiceImpl(final MowerRepository mowerRepositoryParam) {
        this.mowerRepository = mowerRepositoryParam;
    }
    /**
     * Save Mower Instance.
     * @param mower instance to save.
     */
    @Override
    public void save(final Mower mower) {
        mowerRepository.save(mower);
    }
    /**
     * returns all saved Mower instances.
     * @return list of persisted mowers.
     */
    @Override
    public List<Mower> findAll() {
        return mowerRepository.findAll();
    }
    /**
     * Executes a move on Mower.
     * @param mower mower to apply move on.
     * @param move move to apply.
     * @return Mower instance after move application.
     */
    @Override
    public Mower executeMove(final Mower mower, final Move move) {
        switch (move) {
            case G -> mower.turnLeft();
            case D -> mower.turnRight();
            case A -> {
                if (!(mowerRepository
                        .isPositionOccupied(mower
                                .getPosition()
                                .nextForward()))) {
                    mower.moveForward();
                }
            }
            default -> {
                return mower;
            }
        }
        return mower;
    }


}
