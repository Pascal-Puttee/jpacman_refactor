package nl.tudelft.jpacman.npc;

import java.util.*;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.sprite.Sprite;

/**
     * Implementation of an NPC that wanders around randomly.
     *
     * @author Jeroen Roosen
     */
    public final class RandomGhost extends Ghost {

        /**
         * The suggested delay between moves.
         */
        private static final long DELAY = 175L;

        /**
         * Creates a new random ghost.
         *
         * @param ghostSprite
         *            The sprite for the ghost.
         */
        public RandomGhost(Map<Direction, Sprite> ghostSprite) {
            super(ghostSprite, (int) DELAY, 0);
        }

        @Override
        public Optional<Direction> nextAiMove() {
            return Optional.empty();
        }

        /**
         * Determines a possible move in a random direction.
         *
         * @return A direction in which the ghost can move, or <code>null</code> if
         * the ghost is shut in by inaccessible squares.
         */
        @Override
        protected Direction randomMove() {
            Square square = getSquare();
            List<Direction> directions = new ArrayList<>();
            for (Direction direction : Direction.values()) {
                if (square.getSquareAt(direction).isAccessibleTo(this)) {
                    directions.add(direction);
                }
            }
            if (directions.isEmpty()) {
                return null;
            }
            int i = new Random().nextInt(directions.size());
            return directions.get(i);
        }
    }
