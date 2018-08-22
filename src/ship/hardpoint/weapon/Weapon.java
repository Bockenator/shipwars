package ship.hardpoint.weapon;

import ship.hardpoint.Hardpoint;

public abstract class Weapon implements Hardpoint{

    private float cooldown;
    private float damage;
    private float range;

    public Weapon(float cooldown, float damage, float range) {
        this.cooldown = cooldown;
        this.damage = damage;
        this.range = range;
    }

    //TODO: COMPLETE
    public void fire(){

    }

    public float getRange(){
        return this.range;
    }
}
