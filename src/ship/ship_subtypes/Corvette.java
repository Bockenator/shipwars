package ship.ship_subtypes;
 import ship.Ship;
 import ship.ShipSize;
 import ship.section.*;


public class Corvette extends Ship {

    public Corvette(Section [] sections, String name) {
        super(sections, name);
        setShip_size(ShipSize.CORVETTE);
    }

    public Corvette(EngineSection engine, HardpointSection hardpoint, String name){
        super(new Section [] {engine, hardpoint}, name);
        setShip_size(ShipSize.CORVETTE);
    }

}
