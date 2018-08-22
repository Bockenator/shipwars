package ship.hardpoint.weapon.missiletube;

import ship.hardpoint.Hardpoint;

//TODO: COMPLETE THIS AND COMBINE WITH AMMO
public class MissileTube implements Hardpoint{
    private float cooldown;
    private int launch_capacity;

    public MissileTube(float cooldown, int launch_capacity) {
        this.cooldown = cooldown;
        this.launch_capacity = launch_capacity;
    }

    //TODO: COMPLETE
    public void fire(){

    }
}
