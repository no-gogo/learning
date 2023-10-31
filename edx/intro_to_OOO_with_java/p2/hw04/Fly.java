//package edx.intro_to_OOO_with_java.p2.hw04;

// Fly.java

public class Fly {
    private double mass; // kg?
    private double speed; // m/s?

    // Basic Constructor - no parameters
    public Fly(){
        this(5.0); //default
    }


    // Constructor that takes in parameter of mass
    public Fly(double mass){
        this(mass, 10);
    }

    // Constructor that takes in both speed and mass
    public Fly(double mass, double speed){
        this.speed = speed; //default
        this.mass = mass;
    }

    // Function
    /*
    public String toString(){

        if(this.mass == 0){
            System.out.println("I'm dead, but I used to be a fly with a speed of " + this.speed + " .");
            return "I'm dead, but I used to be a fly with a speed of " + this.speed + " .";
        }
        else{
            System.out.println("I'm a speedy fly with " + this.speed + " and " + this.mass + " mass.");
            return "I'm a speedy fly with " + this.speed + " and " + this.mass + " mass.";

        }

    }

     */
    public String toString() {
        String result;
        if (this.mass == 0) {
            result = String.format("I'm dead, but I used to be a fly with a speed of %.2f .", this.speed);
        } else {
            result = String.format("I'm a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
        }
        System.out.println(result);
        return result;
    }

    // Getters and Setters
    public double getMass(){
        return this.mass;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setMass(double mass){
        if (mass >= 0) {
            this.mass = mass;
        } else {
            System.out.println("Mass cannot be negative. Value not set.");
        }
    }

    public boolean isDead(){
        if (this.mass ==0 ){
            //System.out.println("I'm DEAD");
            return true;
        }
        else{
            //System.out.println("I'm still alive!!!");
            return false;
        }
    }

    public void grow(int change_in_mass){

        if ( this.mass < 20){
            if ((20.0 - this.mass) < change_in_mass){
                double x = (20.0 - this.mass);
                this.speed = this.speed + x;
            }
            else{
                this.speed = this.speed + change_in_mass; 
            }
        }
        else{
            this.speed = this.speed - (0.5*change_in_mass);
        }



        this.mass = this.mass + change_in_mass;

        if (this.mass < 0){
            this.mass = 0;
        }

    }
}