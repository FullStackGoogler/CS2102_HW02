/**
 * Represents an athlete's final result.
 */
public class FinalResult {
    ShootingResult shootingResult;
    SkiingResult skiingResult;

    public FinalResult(ShootingResult shootingResult, SkiingResult skiingResult) {
        this.shootingResult = shootingResult;
        this.skiingResult = skiingResult;
    }

    /**
     * Calculates the total score between {@link #shootingResult} and {@link #skiingResult}.
     * @return The sum of the points earned skiing, both the skiing and shooting result's penalties, and an added modifier based on the final skiing position.
     */
    public double finalScore() {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties() + modifier();
    }

    /**
     * Deducts a set amount of points based on the final skiing position.
     * @return The amount of points to be deducted
     */
    private double modifier() {
        switch(skiingResult.finalPosition) {
            case 1:
                return -10;
            case 2:
                return -7;
            case 3:
                return -3;
            case 4:
                return -1;
            default:
                return 0;
        }
    }
}