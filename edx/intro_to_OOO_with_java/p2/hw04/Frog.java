//package edx.intro_to_OOO_with_java.p2.hw04;

public class Frog {
    private String name; 
    private int age; // number of months
    private double tongueSpeed;

    public boolean isFroglet;

    private static String species = "Rare Pepe";

    // Constructor with given ageInYears
    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        this.age = age; // months
        this.tongueSpeed = tongueSpeed;

        // is it a froglet?
        if( this.age > 1 && this.age < 7){
            this.isFroglet = true;
        }
        else{
            this.isFroglet = false;
        }
    }


    // Constructor with given ageInYears
    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name, (int)(ageInYears*12), tongueSpeed);
    }

    // Constructor - Just a Name
    public Frog(String name){
        this(name,5,5);
    }

    public void grow(int months){
        
        // Update tongue speed as it ages
        if( this.age < 12){    
            if ((12 - this.age) < months){
                int x = (12 - this.age);
                this.tongueSpeed = this.tongueSpeed + x;
                
            }
            else{
                this.tongueSpeed = this.tongueSpeed + months;
            }
        }
        else if( this.age > 30 ){
            this.tongueSpeed = this.tongueSpeed - months;

        }
        else if( this.age + months > 30){
            int x = (30 - this.age + months);
            this.tongueSpeed = this.tongueSpeed - x;
        }

        // Set lower bound on tongue speed
        if (this.tongueSpeed < 5 ){
            this.tongueSpeed = 5;
        }

        // Increase age, and check if froglet
        this.age = this.age + months;
        if (this.age > 7){
            this.isFroglet = false;
        }
        else{
            this.isFroglet = true;
        }

    }

    // When grow is called with no parameters, default to grow one month
    public void grow(){
        this.grow(1);
    }

    public void eat(Fly fly){
        if(fly.isDead()){
            System.out.println("I ain't eating a dead fly.");
            //Terminate method
            return;
        }
        
        // Check if the fly is caught
        if (this.tongueSpeed > fly.getSpeed()){
            //Fly is caught
            if(fly.getMass() > (this.age * 0.5)){
                // Grow the frog by one month
                this.grow();
            }
            // Set fly mass to zero, its dead now
            fly.setMass(0);
        }
        else{
            //Fly is not caught

            // Increment fly's mass by one
            fly.setMass(fly.getMass()+1);

        }
    }

    // Frog toString
    /*
    public String toString(){

        if(this.isFroglet){
            System.out.println("My name is " + this.name + " and I'm a rare froglet! I'm " + this.age + " months old and my tongue has a speed of " +  this.tongueSpeed + ".");
            return "My name is " + this.name + " and I'm a rare froglet! I'm " + this.age + " months old and my tongue has a speed of" +  this.tongueSpeed + ".";
        }
        else{
            System.out.println("My name is " + this.name + " and I'm a rare frog. I'm " + this.age + " months old and my tongue has a speed of " +  this.tongueSpeed + ".");
            return "My name is " + this.name + " and I'm a rare frog. I'm " + this.age + " months old and my tongue has a speed of" +  this.tongueSpeed + ".";
        }

    }
    */

    public String toString() {
        String result;
        if (this.isFroglet) {
            result = String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            result = String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
        System.out.println(result);
        return result;
    }

    // Set species
    public void setSpecies(String new_species){
        species = new_species;
    }


    // Set species
    public String getSpecies(){
        return this.species;
    }

}
