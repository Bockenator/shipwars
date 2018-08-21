import agent.ShipCaptainAgent;
import ship.*;
import ship.ammunition.Ammunition;
import ship.hardpoint.Hardpoint;
import ship.hardpoint.weapon.laser.Laser;
import ship.section.EngineSection;
import ship.section.HardpointSection;
import ship.ship_subtypes.Corvette;

import java.util.ArrayList;

public class Main{

    public static void main(String [] args) {

        Laser red_laser = new Laser(10, 100, 1000);
        HardpointSection hardpoint_section = new HardpointSection(new Hardpoint[] {red_laser},
                new Ammunition[] {}, 1000, 1000);
        EngineSection engine_section = new EngineSection(50000, 1000);
        Corvette corvette = new Corvette(engine_section, hardpoint_section, "TEST_SHIP");


        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(corvette);

        String [] agent_ids = new String[1];

        ShipCaptainAgent agent1 = new ShipCaptainAgent("TEST_AGENT", corvette);

        agent_ids[0] = agent1.toString();

        ArenaGame arena = new ArenaGame(ships, agent_ids);
        agent1.start();
        arena.start();
    }
}
