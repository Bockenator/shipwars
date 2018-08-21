package agent.planner;

import action.Action;
import agent.planner.truthvariable.CollisionImminent;
import agent.planner.truthvariable.TruthVariable;
import ship.Ship;

import java.util.ArrayList;

//class that generates a plan for a ship based on a subsumption planning mechanism
public class SubsumptionShipPlanner implements Planner {

    public static ArrayList<Action> generatePlan(Ship ship){
        ArrayList<Action> plan = new ArrayList<Action>();
        ArrayList<TruthVariable> world_state = WorldStateVariableCreator.getWorldStateForShip(ship);

        /*TODO: FINISH SUBSUMPTION PLANNER (ALSO MAYBE RETHINK TRUTHVARIABLE IDEA TO BE ENUMS AND CALC ALL OTHER
        INFO AGAIN AFTERWARDS)*/

        return plan;
    }


}
