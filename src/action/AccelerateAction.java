package action;

import ship.Ship;

// action to describe how a ship should accelerate
public class AccelerateAction extends Action{

    // force increase determines the acceleration of a ship (F = ma)
    private float force_increase;

    public AccelerateAction(Ship ship, float force_increase) {
        super(ship);
        this.force_increase = force_increase;
    }

    public float getForce_increase() {
        return force_increase;
    }
}
