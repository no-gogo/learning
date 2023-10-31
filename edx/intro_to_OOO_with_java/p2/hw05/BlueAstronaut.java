//package edx.intro_to_OOO_with_java.p2.hw05;

public class BlueAstronaut extends Player implements Crewmate{
    private int numTasks;
    private int taskSpeed;

    // Constructors
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name,susLevel);
        this.setNumTasks(numTasks);
        this.setTaskSpeed(taskSpeed);
    }

    public BlueAstronaut(String name){
        this(name, 15, 6, 10);
    }



    // Methods
    @Override
    public void emergencyMeeting(){
        if(this.isFrozen()){
            System.out.println("A player that is frozen can not call an emergency meeting.");
            return;
        }

        // Get current players
        Player[] players = Player.getPlayers();

        // Player with highest susLevel is frozen
        Player mostSus = null;
        boolean susTie = false; // goes high if there is a tie for most sus

        for (Player player : players){
            if(! ((player.isFrozen()) || player.equals(this))){    
                // Are they the most sus?
                if (mostSus == null || player.getSusLevel() > mostSus.getSusLevel()) {
                    mostSus = player;
                    susTie = false;
                }
                else if( player.getSusLevel() == mostSus.getSusLevel()){
                    susTie = true;
                }
            }         
        }

        // Freeze the most sus if there is no tie
        if ( susTie ){
            System.out.println("Tie for most sus, nobody is frozen.");
        }
        else{
            mostSus.setFrozen(true);
        }

        // Check if its a game over
        gameOver();
        
    }

    public void completeTask(){
        // If they are frozen or already have zero tasks, nothing happens
        if(this.isFrozen() || this.getNumTasks() == 0){
            return;
        }
        if(this.getTaskSpeed() > 20){
            this.setNumTasks(this.numTasks - 2);
        }
        else{
            this.setNumTasks(this.numTasks - 1);
        }

        if(this.numTasks == 0){
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int)(this.getSusLevel()*.5));
        }

    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BlueAstronaut that = (BlueAstronaut) obj;
        return (this.getSusLevel() == that.getSusLevel() &&
                this.isFrozen() == that.isFrozen() &&
                this.getName() == that.getName() &&
                this.numTasks == that.numTasks &&
                this.taskSpeed == that.taskSpeed);
    }

    public String toString(){
        String str = "My name is " + this.getName() + ", and I have a suslevel of " + this.getSusLevel() + ". I am currently " + (this.isFrozen() ? "frozen" : "not frozen") + ". I have " + this.getNumTasks() + " left over.";
        if(this.getSusLevel() > 15){
            return str.toUpperCase();
        }
        else{
            return str;
        }
    }

    // Getters and Setters
    private void setNumTasks(int numTasks){
        this.numTasks = ((numTasks > 0) ? numTasks : 0 );
        return;
    } 

    public int getNumTasks(){
        return this.numTasks;
    }

    public void setTaskSpeed(int TaskSpeed){
        this.taskSpeed = TaskSpeed;
    }


    public int getTaskSpeed(){
        return this.taskSpeed;
    }


}
