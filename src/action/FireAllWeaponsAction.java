package action;

import ship.Ship;

// basic action for firing all weapons (no additional vars needed as this will simply cause the ship's fire all method
// to be called)
public class FireAllWeaponsAction extends Action{

    public FireAllWeaponsAction(Ship ship){
        super(ship);
    }
}
