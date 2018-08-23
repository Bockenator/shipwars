package action;

import ship.Ship;

// TODO: REVAMP ACTION SYSTEM TO NOT BE SO CLUNKY
// actions determine what a ship should do (many actions make a plan)
public abstract class Action {

    // each action is for only one ship
    private Ship ship;

    public Action(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
