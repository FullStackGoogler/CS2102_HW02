//Eric Zhou, ezzhou

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Examples {
    //Test Case Variable Initializations
    ShootingRound r1 = new ShootingRound(4, false);
    ShootingRound r2 = new ShootingRound(1, true);
    ShootingRound r3 = new ShootingRound(5, false);
    ShootingRound r4 = new ShootingRound(3, true);
    ShootingRound r5 = new ShootingRound(0, true);
    ShootingRound r6 = new ShootingRound(2, false);
    ShootingRound r7 = new ShootingRound(1, false);
    ShootingRound r8 = new ShootingRound(4, true);

    LinkedList<ShootingRound> shootingRound1 = new LinkedList<>(); {
        shootingRound1.add(r1);
        shootingRound1.add(r2);
        shootingRound1.add(r3);
        shootingRound1.add(r4);
    }
    LinkedList<ShootingRound> shootingRound2 = new LinkedList<>(); {
        shootingRound2.add(r5);
        shootingRound2.add(r6);
        shootingRound2.add(r7);
        shootingRound2.add(r8);
    }
    LinkedList<ShootingRound> shootingRound3 = new LinkedList<>(); {
        shootingRound3.add(r1);
        shootingRound3.add(r2);
        shootingRound3.add(r3);
        shootingRound3.add(r4);
        shootingRound3.add(r5);
        shootingRound3.add(r6);
        shootingRound3.add(r7);
        shootingRound3.add(r8);
    }
    LinkedList<ShootingRound> shootingRound4 = new LinkedList<>(); {
        shootingRound4.add(r1);
        shootingRound4.remove(r1); //lol
    }

    ShootingResult shootingResult1 = new ShootingResult(shootingRound1);
    ShootingResult shootingResult2 = new ShootingResult(shootingRound2);
    ShootingResult shootingResult3 = new ShootingResult(shootingRound3);
    ShootingResult shootingResult4 = new ShootingResult(shootingRound4);

    SkiingResult skiingResult1 = new SkiingResult(3, 49.8, 41.0, 46.1, 45.6, 5);
    SkiingResult skiingResult2 = new SkiingResult(1, 31.4, 30.7, 32.4, 31.2, 1);
    SkiingResult skiingResult3 = new SkiingResult(4, 58.6, 59.7, 52.3, 55.4, 2);
    SkiingResult skiingResult4 = new SkiingResult(7, 79.6, 85.6, 82.1, 74.3, 7);

    MassStartResult massStartResult = new MassStartResult(8, 3, 15.6, 19.4, 22.3, 18.6, 0);

    Athlete athl1 = new Athlete(new FinalResult(shootingResult1, skiingResult1), "James");
    Athlete athl2 = new Athlete(new FinalResult(shootingResult2, skiingResult2), "Zeb");
    Athlete athl3 = new Athlete(new FinalResult(shootingResult3, skiingResult3), "Adrianna");
    Athlete athl4 = new Athlete(new FinalResult(shootingResult4, skiingResult4), "Nick");

    LinkedList<Athlete> lathl1 = new LinkedList<>(); {
        lathl1.add(athl1);
        lathl1.add(athl2);
        lathl1.add(athl3);
        lathl1.add(athl4);
    }
    LinkedList<Athlete> lathl2 = new LinkedList<>(); {
        lathl2.add(athl1);
        lathl2.add(new Athlete(new FinalResult(new ShootingResult(new LinkedList<>(Arrays.asList(new ShootingRound(1, true), new ShootingRound(3, false), new ShootingRound(2, false), new ShootingRound(5, true)))), skiingResult2), "Zeb"));
        lathl2.add(athl3);
        lathl2.add(new Athlete(new FinalResult(shootingResult4, new SkiingResult(9, 96.5, 87.6, 91.8, 93.4, 17)), "Nick"));
    }

    Competition comp1 = new Competition(1, lathl1);
    Competition comp2 = new Competition(6, lathl1);
    Competition comp3 = new Competition(0, lathl2);
    Competition comp4 = new Competition(9, lathl2);

    @Test
    public void checkShootingPointsEarned() {
        assertEquals(7, shootingResult2.pointsEarned(), 0.01);
        assertEquals(20, shootingResult3.pointsEarned(), 0.01);
    }
    @Test
    public void checkSkiingPointsEarned() {
        assertEquals(182.5, skiingResult1.pointsEarned(), 0.01);
        assertEquals(321.6, skiingResult4.pointsEarned(), 0.01);
    }
    @Test
    public void checkMassStartPointsEarned() {
        assertEquals(75.9, massStartResult.pointsEarned(), 0.01);
    }

    @Test
    public void checkBestRoundByType() {
        assertEquals(r4, shootingResult1.bestRoundByType(true));
        assertEquals(r3, shootingResult1.bestRoundByType(false));
        assertEquals(r8, shootingResult3.bestRoundByType(true));
        assertEquals(r3, shootingResult3.bestRoundByType(false));
        assertEquals(r5, new ShootingResult(new LinkedList<>(Arrays.asList(r5, r6, r7))).bestRoundByType(true));
        assertNull(shootingResult4.bestRoundByType(true));
        assertNull(shootingResult4.bestRoundByType(false));
    }

    @Test
    public void checkShootingDNF() {
        assertEquals(new LinkedList<>(Arrays.asList("Nick")), comp1.shootingDNF());
        assertEquals(new LinkedList<>(Arrays.asList("James", "Zeb", "Nick")), comp2.shootingDNF());
        assertEquals(new LinkedList<String>(), comp3.shootingDNF());
        assertEquals(new LinkedList<>(Arrays.asList("James", "Zeb", "Adrianna", "Nick")), comp4.shootingDNF());
    }

    @Test
    public void checkFinalScoreForAthlete() {
        assertEquals(athl1.finalresult.finalScore(), comp1.finalScoreForAthlete("James"), 0.01);
        assertEquals(athl1.finalresult.finalScore(), comp2.getAthletes().get(0).finalresult.finalScore(), 0.01);
        assertEquals(athl3.finalresult.finalScore(), comp1.finalScoreForAthlete("Adrianna"), 0.01);
        assertEquals(454.3, lathl2.get(3).finalresult.finalScore(), 0.01);
    }

    @Test
    public void checkAnyImprovement() {
        assertFalse(comp1.anyImprovement(comp1));
        assertFalse(comp1.anyImprovement(comp2));
        assertFalse(comp3.anyImprovement(comp4));
        assertTrue(comp1.anyImprovement(comp3));
        assertTrue(comp3.anyImprovement(comp1));
    }

    @Test
    public void checkFindAthlete() {
        assertEquals(athl4, comp1.findAthlete("Nick", comp1));
        assertNull(comp3.findAthlete("Zaq", comp3));
    }
}