package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.Sprite;

/**
     * A wall is a square that is inaccessible to anyone.
     *
     * @author Jeroen Roosen
     */
    public class Wall extends Square {

        /**
         * The background for this square.
         */
        private final Sprite background;

        /**
         * Creates a new wall square.
         *
         * @param sprite
         *            The background for the square.
         */
        Wall(Sprite sprite) {
            this.background = sprite;
        }

        @Override
        public boolean isAccessibleTo(Unit unit) {
            return false;
        }

        @Override
        public Sprite getSprite() {
            return background;
        }
    }
