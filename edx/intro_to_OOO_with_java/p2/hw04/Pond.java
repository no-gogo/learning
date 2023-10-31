//package edx.intro_to_OOO_with_java.p2.hw04;

public class Pond {
    public static void main(String[] args) {
        // Create 4 frogs
        Frog Peepo = new Frog( "Peepo");
        Frog Pepe = new Frog("Pepe",  10,  15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog FROGINATOR = new Frog("FROGINATOR", 600, 100);

        // Create 3 flies
        Fly fly1 = new Fly(1,3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly();
        
        // Go through Operations

        // 1 Set the species of any Frog to “1331 Frogs”
        Peepo.setSpecies("1331 Frogs");

        // 2 Print out on a new line the description of the Frog named Peepo given by the toString method.
        Peepo.toString();

        // 3 Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        Peepo.eat(fly2);

        // 4 Print out on a new line the description of the Fly with a mass of 6 given by the toString method.
        fly2.toString();
        
        // 5 Have the Frog named Peepo grow by 8 months.
        Peepo.grow(8);

        // 6 Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        Peepo.eat(fly2);

        // 7 Print out on a new line the description of the Fly with a mass of 6 given by the toString method.
        fly2.toString();

        // 8 Print out on a new line the description of the Frog named Peepo given by the toString method.
        Peepo.toString();
   
        // 9 Print out on a new line the description of your own Frog given by the toString method.
        FROGINATOR.toString();

        // 10 Have the Frog named Peepaw grow by 4 months.
        Peepaw.grow(4);

        // 11 Print out on a new line the description of the Frog named Peepaw given by the toString method.
        Peepaw.toString();

        // 12 Print out on a new line the description of the Frog named Pepe given by the toString method.
        Pepe.toString();
    }
}
