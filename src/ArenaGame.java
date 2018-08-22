import action.AccelerateAction;
import action.Action;
import ship.*;
import agent.*;
import utilities.*;

import java.util.*;

// arena in which ships and other objects are placed and in which the battle takes place
public class ArenaGame extends Observable implements Runnable {

    // setup for seperate thread to run arena
    Thread arena_thread;
    String arena_thread_name = "ARENA_THREAD";

    // list of observers
    private ArrayList<Observer> agent_observers = new ArrayList<Observer>();

    // basic arena parameters
    private float arena_radius = 5000;
    private float collision_cube_length = 1000;

    // list of ships in the arena
    private ArrayList<Ship> ships;
    // hashmap of Agent Plans using Agent IDs as keys
    public HashMap<String, ArrayList<Action>> agent_plans;
    // same as the keys in agent_plans hashmap (used to avoid mutiple getKeys() calls)
    public String [] agent_ids;

    // constructor
    public ArenaGame(ArrayList<Ship> ships, String [] agent_ids) {
        this.ships = ships;
        this.agent_ids = agent_ids;
        init();
    }

    // initialiser
    private void init(){
        agent_plans = new HashMap<>();
        //initialise the agent plans
        for (String agent_id : agent_ids){
            ArrayList<Action> temp = new ArrayList<>();
            System.out.println(agent_id);
            agent_plans.put(agent_id, temp);
        }
    }

    // basic gamestate update
    public void update(){
        generateAgentActions();
        checkCollisionsBAD();
    }


    public void generateAgentActions(){

    }

    // enact one step of each agents plan (if an agent is out of a plan then notify)
    public void actOnPlans(){
        // get the next action, execute it, then remove the action from the plan
        for (String agent : agent_ids) {
            try {
                Action current_action = agent_plans.get(agent).get(0);
                executeAction(current_action);
                //TODO: DOES THIS CAUSE PROBLEMS IF THE LAST PLAN ITEM IS REMOVED?
                agent_plans.get(agent).remove(0);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("WARNING: agent "+agent+" has no plan");
                notifyObservers(agent);
            }

        }
    }

    // execute one action
    public void executeAction(Action current_action){
        if (current_action instanceof AccelerateAction){
            current_action.getShip().accelerate(((AccelerateAction) current_action).getForce_increase());
        }
    }


    // TODO: IMPLEMENT PROPER COLLISION CHECKING (MAYBE PHYSICS LIBRARY?)
    public void checkCollisionsBAD(){
        //Check all inter-ship collisions
        for (int i = 0; i < ships.size(); i++ ){
            for (int j = i + 1; j < ships.size(); j++){

                float distance = ships.get(i).getLocation().getEuclideanDistance(ships.get(j).getLocation());

                //TODO: CHANGE TO REASONABLE (OR EXACT) DISTANCE
                if (distance <= 1){
                    System.out.println("COLLISON: "+ships.get(i).toString()+" AND "+ships.get(j).toString());
                }
            }
        }
    }

    //TODO: IMPLEMENT PROPER COLLISION CHECKING (MAYBE PHYSICS LIBRARY?)
    public void genCollisionCubeList(){
        int num_cubes = (int) ((2*arena_radius)/collision_cube_length);
        Ship [][] collision_cubes = new Ship[num_cubes][num_cubes];
    }


    // thread start method
    public void start(){
        System.out.println("STARTING THREAD: "+arena_thread_name);
        if (arena_thread == null){
            arena_thread = new Thread(this, arena_thread_name);
            arena_thread.start();
        }
    }

    // thread run method
    @Override
    public void run() {
        System.out.println("ARENA THREAD "+arena_thread_name+" RUNNING");
        try{
            //actOnPlans();
            this.arena_thread.sleep(100);
        }
        catch(InterruptedException e){
            System.out.println("INTERRUPTED THREAD: "+arena_thread_name);
        }
    }



}
