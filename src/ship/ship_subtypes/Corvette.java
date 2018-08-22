package ship.ship_subtypes;
 import ship.Ship;
 import ship.ShipSize;
 import ship.section.*;

// corvette template (made out of only a few sections)
public class Corvette extends Ship {

    // generic constructor
    public Corvette(Section [] sections, String name) {
        super(sections, name);
        setShip_size(ShipSize.CORVETTE);
    }

    // simple corvette constructor (most corvettes should use this)
    public Corvette(EngineSection engine, HardpointSection hardpoint, String name){
        super(new Section [] {engine, hardpoint}, name);
        setShip_size(ShipSize.CORVETTE);
    }

}
