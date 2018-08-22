package agent.planner;

import agent.planner.truthvariable.TruthVariable;
import ship.Ship;
import utilities.Contact;
import utilities.TargetClassification;

import java.util.ArrayList;


// class for world state creation
public class WorldStateVariableCreator {


    // method to generate a world state for the planner based on ship data
    public static ArrayList<TruthVariable> getWorldStateForShip(Ship ship){

        ArrayList<TruthVariable> world_state = new ArrayList<TruthVariable>();

        // check for any contacts which are enemy
        for (Contact c : ship.getContacts()){
            if (c.getClassification() == TargetClassification.ENEMY){
                world_state.add(TruthVariable.ENEMY_ON_RADAR);
                break;
            }
        }

        // check for any close contacts on a collision course
        if(!(ship.getOn_collision_course().isEmpty())){
            world_state.add(TruthVariable.COLLISION_IMMINENT);
        }

        // check if a contact is an enemy and then check for distance
        if(!(ship.getNearby_enemies().isEmpty())){
            for(Contact c : ship.getNearby_enemies()) {
                float dist = c.getLocation().getEuclideanDistance(ship.getLocation());
                // if the contact is within in weapon range, generate enemy in weapon range truthvariable
                if (dist < ship.getMax_weapon_range()) {
                    world_state.add(TruthVariable.ENEMY_IN_RANGE);
                    break;
                }
            }
            world_state.add(TruthVariable.ENEMY_NEARBY);

        }

        return world_state;
    }
}
