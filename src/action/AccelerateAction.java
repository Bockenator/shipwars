package action;

import ship.Ship;

public class AccelerateAction extends Action{

    private float force_increase;

    public AccelerateAction(Ship ship, float force_increase) {
        super(ship);
        this.force_increase = force_increase;
    }

    public float getForce_increase() {
        return force_increase;
    }
}
