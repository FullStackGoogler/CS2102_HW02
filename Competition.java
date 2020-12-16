import java.util.LinkedList;

/**
 * Represents a competition.
 */
public class Competition {
    private final int numRounds;
    private final LinkedList<Athlete> athletes;

    public Competition(int numRounds, LinkedList<Athlete> athletes) {
        this.numRounds = numRounds;
        this.athletes = athletes;
    }

    /**
     * Finds all athletes whose {@link ShootingResult} has less shooting rounds than the amount of rounds used in this competition
     * @return A list of the names of athletes who did not finish this competition.
     */
    public LinkedList<String> shootingDNF() {
        LinkedList<String> names = new LinkedList<>();

        for(Athlete athlete : athletes) {
            if(athlete.finalresult.shootingResult.rounds.size() < numRounds) {
                names.add(athlete.name);
            }
        }
        return names;
    }

    /**
     * Finds the final score of a given athlete, assuming no two athletes have the same name, and that the athlete is in the competition.
     * @param name The name of the athlete.
     * @return The final score of the given athlete.
     */
    public double finalScoreForAthlete(String name) {
        for(Athlete athlete : athletes) {
            if(athlete.name.equalsIgnoreCase(name)) {
                return athlete.finalresult.finalScore();
            }
        }
        return 0;
    }

    /**
     * Determines if any athlete has a better final score in this competition than a given competition, assuming both competitions have the same athletes.
     * @param compOther Another competition.
     * @return True if any athlete in this competition has a lower final score than in another competition.
     */
    public boolean anyImprovement(Competition compOther) {
        for(Athlete athlete : athletes) {
            if(athlete.finalresult.finalScore() < findAthlete(athlete.name, compOther).finalresult.finalScore()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds an athlete with a matching name in a given competition.
     * @param name The athlete to be found.
     * @param comp The competition to search in.
     * @return An athlete with a matching name
     */
    public Athlete findAthlete(String name, Competition comp) {
        for(Athlete athlete : comp.athletes) {
            if(athlete.name.equalsIgnoreCase(name)) {
                return athlete;
            }
        }
        return null;
    }

    public LinkedList<Athlete> getAthletes() { return athletes; }
}
//For finalScoreForAthlete(), there is no need for a helper method, as it only consists of a simple String.equals() check.
//For anyImprovement(), I created a helper method findAthlete() to make the code clearer to understand.