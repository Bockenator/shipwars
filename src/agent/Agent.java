package agent;

// agents interact with and control objects in the world and objects within the world
// agents run on their own thread
public abstract class Agent implements Runnable{
    // thread parameters
    Thread agent_thread;
    String agent_thread_name;

    // agent parameters
    String agent_name;

    // constructor
    public Agent(String agent_name){
        this.agent_name = agent_name;
        init();
    }

    // init method
    private void init(){
        // set the thread name based on agent name
        this.agent_thread_name = this.agent_name+"_THREAD";
    }

    // thread start method
    public void start(){
        System.out.println("STARTING THREAD: "+agent_thread_name);
        if (agent_thread == null){
            agent_thread = new Thread(this, agent_thread_name);
            agent_thread.start();
        }
    }

    // thread run method
    public void run(){
        System.out.println("DEFAULT AGENT THREAD "+agent_thread_name+" RUNNING");

        try{
            Thread.sleep(50);
        }
        catch(InterruptedException e){
            System.out.println("INTERRUPTED THREAD: "+agent_thread_name);
        }

    }

    public String toString(){
        return this.agent_name;
    }
}
