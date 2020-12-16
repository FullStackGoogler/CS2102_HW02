import java.util.LinkedList;

public class CompileCheck {
    public static void main(String[] args) {
        //Order of parameters in MassStartResult: starting position, finishing position, four laps, number of penalties
        MassStartResult dummyRun = new MassStartResult(3, 2, 1.0, 2.0, 3.0, 4.0, 3);
        double runSum = dummyRun.pointsEarned();

        LinkedList<ShootingRound> rounds = new LinkedList<>();
        ShootingRound b1 = new ShootingRound(0, true);
        ShootingRound b2 = new ShootingRound(4, false);
        ShootingRound b3 = new ShootingRound(5, true);
        ShootingRound b4 = new ShootingRound(2, true);

        rounds.add(b1);
        rounds.add(b2);
        rounds.add(b3);
        rounds.add(b4);

        LinkedList<ShootingRound> rounds2 = new LinkedList<>();
        ShootingRound b6 = new ShootingRound(0, true);
        ShootingRound b7 = new ShootingRound(4, false);
        ShootingRound b8 = new ShootingRound(5, false);
        ShootingRound b9 = new ShootingRound(2, true);

        rounds2.add(b6);
        rounds2.add(b7);
        rounds2.add(b8);
        rounds2.add(b9);

        ShootingResult result1 = new ShootingResult(rounds);
        ShootingResult result2 = new ShootingResult(rounds2);
        ShootingRound sh1 = result1.bestRoundByType(true);

        SkiingResult dummySkiResult = new SkiingResult(2, 1.0, 2.0, 3.0, 4.0, 3);
        double skiSum = dummySkiResult.pointsEarned();

        FinalResult finalResult = new FinalResult(result1, dummySkiResult);
        double x = finalResult.finalScore();

        Athlete a1 = new Athlete(finalResult, "Athlete1");
        Athlete a2 = new Athlete(finalResult, "Athlete2");

        LinkedList<Athlete> athletes = new LinkedList<>();
        athletes.add(a1);
        athletes.add(a2);

        Competition comp = new Competition(5, athletes);
        LinkedList<String> test1 = comp.shootingDNF();

        boolean test2 = comp.anyImprovement(comp);
        double test5 = comp.finalScoreForAthlete("Athlete1");
        System.out.println("Congrats! Your program compiled and ran!");
    }
}