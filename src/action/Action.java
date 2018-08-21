package action;

import ship.Ship;

public abstract class Action {

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
