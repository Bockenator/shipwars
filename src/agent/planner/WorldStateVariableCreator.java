package agent.planner;

import agent.planner.truthvariable.CollisionImminent;
import agent.planner.truthvariable.EnemyInWeaponsRange;
import agent.planner.truthvariable.EnemyNearby;
import agent.planner.truthvariable.TruthVariable;
import ship.Ship;
import utilities.Contact;
import utilities.Target_Classification;

import java.util.ArrayList;


// class for world state creation
public class WorldStateVariableCreator {


    // method to generate a world state for the planner based on ship data
    public static ArrayList<TruthVariable> getWorldStateForShip(Ship ship){
        ArrayList<TruthVariable> world_state = new ArrayList<TruthVariable>();

        for(Contact c : ship.getContacts()){

            // check for any contacts close (within 50km)
            if(c.getLocation().getEuclideanDistance(ship.getLocation()) < 50){

                // any close objects on a collision course will generate a collision imminent truthvariable
                if(c.getLocation().willCollideWith(ship.getLocation().getDirection_vector())){
                    world_state.add(new CollisionImminent(c.getLocation()));
                }
            }

            // check if a contact is an enemy and then check for distance
            if(c.getClassification().equals(Target_Classification.ENEMY)){

                float dist = c.getLocation().getEuclideanDistance(ship.getLocation());

                // if the contact is within in weapon range, generate enemy in weapon range truthvariable
                if (dist < ship.getMax_weapon_range()) {

                    world_state.add(new EnemyInWeaponsRange(c.getLocation()));
                }

                // if the enemy is within 2000km generate an enemy nearby truthvaribale
                if (dist < 2000){

                    world_state.add(new EnemyNearby(c.getLocation()));
                }
            }
        }

        return world_state;
    }
}
