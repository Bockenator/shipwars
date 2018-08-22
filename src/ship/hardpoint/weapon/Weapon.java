package ship.hardpoint.weapon;

import ship.hardpoint.Hardpoint;

public abstract class Weapon implements Hardpoint{

    // weapon parameters
    private float cooldown;
    private float damage;
    private float range;

    // this variable represents the current cooldown of the weapon
    private float current_cd = 0;

    public Weapon(float cooldown, float damage, float range) {
        this.cooldown = cooldown;
        this.damage = damage;
        this.range = range;
    }

    //TODO: COMPLETE
    public boolean fire(){

        // if the weapon is still on cooldown then weapon cannot fire
        if (this.current_cd > 0){
            return false;
        }
        // otherwise update current cooldown to weapon cooldown
        else{
            this.current_cd = this.cooldown;
        }
        return true;
    }

    //TODO: CHANGE THIS TO AUTOMATICALLY RETURN THE PROJECTILE IT FIRES
    // reduces cooldown of weapon based on the time that has passed
    public void reduceCooldown(float time){

        // only reduce cooldown if the weapon is not already ready to fire
        if (this.current_cd > 0){

            if ((this.current_cd - time) < 0){
                this.current_cd = 0;
            }
            else{
                this.current_cd-=time;
            }

        }
    }

    // check if the weapon is ready to fire
    public boolean readyToFire(){

        if (this.current_cd > 0){
            return false;
        }

        return true;
    }

    public float getRange(){
        return this.range;
    }

    public float getDamage(){
        return this.damage;
    }
}
