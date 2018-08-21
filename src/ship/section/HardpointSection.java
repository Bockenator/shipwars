package ship.section;
import ship.ammunition.Ammunition;
import ship.hardpoint.*;

public class HardpointSection extends Section{

    Hardpoint [] hardpoints;
    Ammunition [] ammunitions;
    private int max_ammo;

    public HardpointSection(Hardpoint[] hardpoints, Ammunition[] ammunitions, int max_ammo, float mass) {
        super(mass);
        this.hardpoints = hardpoints;
        this.ammunitions = ammunitions;
        this.max_ammo = max_ammo;
    }

    //TODO: Implement firing methods
    public void fire(){

    }
}
