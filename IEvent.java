public interface IEvent {
    /**
     * Calculates and returns the total points earned.
     * @return The total points earned.
     */
    double pointsEarned();

    /**
     * Calculates and returns the total penalty time issued.
     * @return The total penalty time.
     */
    double getPenalties();
}