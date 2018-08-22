package ship.hardpoint.weapon.massdriver;

import ship.hardpoint.weapon.Weapon;

//TODO: COMPLETE AND COMBINE WITH AMMO
public class MassDriver extends Weapon{
    float projectile_speed;
    // constructor
    public MassDriver(float cooldown, float damage, float range, float projectile_speed) {
        super(cooldown, damage, range);
        this.projectile_speed = projectile_speed;
    }

    public float getProjectile_speed() {
        return projectile_speed;
    }
}
