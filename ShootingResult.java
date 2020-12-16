import java.util.LinkedList;

/**
 * Represents a shooting result.
 */
public class ShootingResult implements IEvent {
    LinkedList<ShootingRound> rounds;

    public ShootingResult(LinkedList<ShootingRound> rounds) {
        this.rounds = rounds;
    }

    /**
     * Finds the best shooting round by shooting round type.
     * @param isStanding True if the shooting round type is standing, False if the type is prone.
     * @return The best round in {@link #rounds} of the given shooting round type.
     */
    public ShootingRound bestRoundByType(boolean isStanding) {
        if(!rounds.isEmpty()) {
            ShootingRound result = new ShootingRound(0, isStanding);

            for(ShootingRound shootingRound : rounds) {
                if(shootingRound.isStanding == isStanding && shootingRound.targetsHit >= result.targetsHit) {
                    result = shootingRound;
                }
            }
            return result;
        }
        return null;
    }

    /**
     * Calculates the total points earned in a shooting result.
     * @return The total targets hit in {@link #rounds}.
     */
    public double pointsEarned() {
        double result = 0;

        for(ShootingRound shootingRound: rounds) {
            result += shootingRound.targetsHit;
        }
        return result;
    }

    /**
     * Calculates the penalty time in seconds of a shooting result.
     * @return The total targets missed multiplied by 60.
     */
    public double getPenalties() {
        return 60 * ((5 * rounds.size()) - (int) pointsEarned());
    }
}