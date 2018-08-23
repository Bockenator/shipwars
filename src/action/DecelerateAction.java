package action;

import ship.Ship;

// action to describe how a ship should decelerate
public class DecelerateAction extends Action {

    // force decrease determines the acceleration of a ship (F = ma)
    private float force_decrease;

    public DecelerateAction(Ship ship, float force_increase) {
        super(ship);
        this.force_decrease = force_increase;
    }

    public float getForce_decrease() {
        return force_decrease;
    }
}
