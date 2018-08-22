package ship.section;
import ship.Ship;
import ship.ShipSize;
//TODO: COMPLETE
public class HangarSection extends Section{
    private int max_capacity;
    private ShipSize max_size;
    private int launch_capacity;
    Ship [] stored_ships;
    private float mass;

    // constructor
    public HangarSection(int max_capacity, ShipSize max_size, int launch_capacity, Ship[] stored_ships, float mass) {
        super(mass);
        this.max_capacity = max_capacity;
        this.max_size = max_size;
        this.launch_capacity = launch_capacity;
        this.stored_ships = stored_ships;
    }

    //TODO: COMPLETE
    public void launch(){

    }

    //TODO: COMPLETE
    public void recall(){

    }
}
