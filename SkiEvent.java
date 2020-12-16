import java.util.LinkedList;

/**
 * Represents a generic skiing event.
 */
public abstract class SkiEvent implements IEvent {
    int finalPosition;
    int penalties;
    LinkedList<Double> laps = new LinkedList<>();

    public SkiEvent(int pos, double lap1, double lap2, double lap3, double lap4, int penalties) {
        this.finalPosition = pos;
        this.penalties = penalties;
        laps.add(lap1);
        laps.add(lap2);
        laps.add(lap3);
        laps.add(lap4);
    }

    /**
     * Calculates the total points earned in a skiing result.
     * @return The sum of each lap time in {@link #laps}.
     */
    public double pointsEarned() {
        double result = 0;

        for(double lapTime: laps) {
            result += lapTime;
        }
        return result;
    }

    /**
     * Calculates the penalty in seconds of a skiing result.
     * @return The amount of {@link #penalties} multiplied by 5.
     */
    public double getPenalties() {
        return 5 * penalties;
    }
}