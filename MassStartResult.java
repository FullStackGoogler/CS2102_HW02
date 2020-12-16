/**
 * Represents a Mass Start event.
 */
public class MassStartResult extends SkiEvent {
    private final int startPosition;

    public MassStartResult(int startPos, int finalPos, double lap1, double lap2, double lap3, double lap4, int penalties) {
        super(finalPos, lap1, lap2, lap3, lap4, penalties);
        this.startPosition = startPos;
    }
}