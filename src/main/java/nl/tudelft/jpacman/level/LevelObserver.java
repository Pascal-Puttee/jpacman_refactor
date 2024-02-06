package nl.tudelft.jpacman.level;

 /**
     * An observer that will be notified when the level is won or lost.
     *
     * @author Jeroen Roosen
     */
    public interface LevelObserver {

        /**
         * The level has been won. Typically the level should be stopped when
         * this event is received.
         */
        void levelWon();

        void lifeLost(Player player);

        /**
         * The level has been lost. Typically the level should be stopped when
         * this event is received.
         */
        void levelLost();
    }