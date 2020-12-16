/**
 * Represents an athlete.
 */
public class Athlete {
    FinalResult finalresult;
    String name;

    public Athlete(FinalResult finalresult, String name) {
        this.finalresult = finalresult;
        this.name = name;
    }

    /**
     * Determines if they have a lower ski time (w/o penalties) than a given Athlete.
     * @param athlete The athlete being compared to.
     * @return True if they do have a lower ski time.
     */
    public boolean betterSkiier(Athlete athlete) {
        return finalresult.skiingResult.pointsEarned() < athlete.finalresult.skiingResult.pointsEarned();
    }

    /**
     * Determines if they have a higher shooting score (w/o penalties) than a given Athlete.
     * @param athlete The athlete being compared to.
     * @return True if they have a higher shooting score.
     */
    public boolean betterShooter(Athlete athlete) {
        return finalresult.shootingResult.pointsEarned() > athlete.finalresult.shootingResult.pointsEarned();
    }

    /**
     * Determines if they have a lower ski time OR a higher shooting score.
     * @param athlete The athlete being compared to.
     * @return True if either condition is satisfied.
     */
    public boolean hasBeaten(Athlete athlete) {
        return (betterSkiier(athlete)) || (betterShooter(athlete));
    }
}