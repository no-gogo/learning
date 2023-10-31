//package edx.intro_to_OOO_with_java.p2.hw05;

public class RedAstronaut extends Player implements Impostor{
    // Variables 
    private String skill; //inexperienced, experienced or expert


    // Constructors
    public RedAstronaut(String name, int susLevel, String skill){
        super(name,susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name){
        this(name, 15, "experienced");
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
                // Debug
                //if( ! (mostSus == null)){
                //    System.out.println("Comparing " + player.getName() + ", " + player.getSusLevel() + "sus. To:" + + mostSus.getSusLevel() + " sus.");
                //}    

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
    
    // Freeze Method
    @Override
    public void freeze(Player p){
        // Players who are frozen can't freeze, and can't freeze someone whose already frozen
        if(this.isFrozen() || p.isFrozen()){
            return;
        }
        // If the passed in player is an imposter, end
        if (p instanceof Impostor) {
            System.out.println("This player is an impostor!");
            return;
        }

        // Freeze is successful if freeze-e's susLevel is less than player's susLevel
        if ( p.getSusLevel() > this.getSusLevel()){
            System.out.println("Freeze.");
            p.setFrozen(true);
        }
        else{
            System.out.println("Failed to freeze. You're double sus now.");
            this.setSusLevel(getSusLevel()*2);
        }

        // Check if the game is over
        gameOver();

    }

    // Sabotage method
    @Override
    public void sabotage(Player p){
        // Players who are frozen can't sabotage, and can't sabotage someone whose already frozen
        // Also can't sabotage another Imposter
        if(this.isFrozen() || p.isFrozen() || p instanceof Impostor){
            return;
        }

        if(this.getSusLevel() < 20){
            //System.out.println("New Sus level: " + p.getSusLevel()*1.5);
            p.setSusLevel((int)(p.getSusLevel()*1.5));
        }
        else{
            p.setSusLevel((int)(p.getSusLevel()*1.25));
        }

        System.out.println("Sabotage.");
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RedAstronaut that = (RedAstronaut) obj;
        return this.getSusLevel() == that.getSusLevel() &&
               this.isFrozen() == that.isFrozen() &&
               this.getName().equals(that.getName()) &&
               this.skill.equals(that.skill);
    }

    public String toString(){
        String str = "My name is " + this.getName() + ", and I have a suslevel of " + this.getSusLevel() + ". I am currently " + (this.isFrozen() ? "frozen" : "not frozen") + ". I am an " + this.getSkill() + " player!";
        if(this.getSusLevel() > 15){
            return str.toUpperCase();
        }
        else{
            return str;
        }
    }

    // Getters and Setters
    public void setSkill(String skill){
        this.skill = skill;
    }


    public String getSkill(){
        return this.skill;
    }

}
