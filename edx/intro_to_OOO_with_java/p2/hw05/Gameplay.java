//package edx.intro_to_OOO_with_java.p2.hw05;

public class Gameplay {

    public static void main(String[] args){
        // Create Players - Crewmates
        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);

        // Create Players - Imposters 
        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SusBoy = new RedAstronaut("Suspicious Person", 100, "expert");
        
        // 1 Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:
        System.out.println("Step 1\n\n");
        Liam.sabotage(Bob);
        System.out.println(Bob.toString());

        // 2 Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
        System.out.println("Step 2\n\n");
        Liam.freeze(SusBoy);
        System.out.println(SusBoy.toString());

        // 3 Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
        System.out.println("Step 3\n\n");
        Liam.freeze(Albert);
        System.out.println(Liam.toString());
        System.out.println(Albert.toString());

        // 4 Have BlueAstronaut Albert call an emergency meeting:
        System.out.println("Step 4\n\n");
        Albert.emergencyMeeting();

        // 5 Have RedAstronaut Suspicious Person call an emergency meeting:
        System.out.println("Step 5\n\n");
        SusBoy.emergencyMeeting();
        System.out.println(Heath.toString());
        System.out.println(Bob.toString());


        // 6 Have BlueAstronaut Bob call an emergency meeting:
        System.out.println("Step 6\n\n");
        Bob.emergencyMeeting();
        System.out.println(SusBoy.toString());

        // 7 Have BlueAstronaut Heath complete tasks:
        System.out.println("Step 7\n\n");
        Heath.completeTask();
        System.out.println(Heath.toString());

        // 8  Have BlueAstronaut Heath complete tasks:
        System.out.println("Step 8\n\n");
        Heath.completeTask();
        System.out.println(Heath.toString());

        // 9 Have BlueAstronaut Heath complete tasks:
        System.out.println("Step 9\n\n");
        Heath.completeTask();
        System.out.println(Heath.toString());

        // 10 Have RedAstronaut Liam freeze Angel:
        System.out.println("Step 10\n\n");
        Liam.freeze(Angel);
        System.out.println(Angel.toString());
        System.out.println(Liam.toString());
                

        // 11 Have RedAstronaut Liam sabotage Bob twice:
        System.out.println("Step 11\n\n");
        Liam.sabotage(Bob);
        Liam.sabotage(Bob);
        System.out.println(Bob.toString());

        // 12 Have RedAstronaut Liam freeze Bob:
        System.out.println("Step 12\n\n");
        Liam.freeze(Bob);
        System.out.println(Bob.toString());

        // 13 Have BlueAstronaut Angel call emergency meeting:
        //Angel.emergencyMeeting();
        //System.out.println(Liam.toString());


        // 14 Have RedAstronaut Liam call sabotage on Heath 5 times:
        System.out.println("Step 14\n\n");
        for (int x = 0; x < 5; x++){
            Liam.sabotage(Heath);
            System.out.println(Heath.toString());
        }

        // 15 Have RedAstronaut Liam freeze Heath:
        System.out.println("Step 15\n\n");
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.freeze(Heath);
    
    }

}
