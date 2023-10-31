import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. Print out a message:
        System.out.println("Welcome to Battleship!");
        
        // 2. Prompt each user to enter coordinates for five ships of length one
        int[][] player_one_ships = new int[5][2];
        int[][] player_two_ships = new int[5][2];

        // before we get user input, set all ships to -1
        for (int i = 0; i < player_one_ships.length; i++) {
            for (int j = 0; j < player_one_ships[i].length; j++) {
                player_one_ships[i][j] = -1;
            }
        }

        for (int i = 0; i < player_two_ships.length; i++) {
            for (int j = 0; j < player_two_ships[i].length; j++) {
                player_two_ships[i][j] = -1;
            }
        }

        char[][] player_one_location_board = new char[5][5];
        char[][] player_two_location_board = new char[5][5];

        char[][] player_one_target_history_board = new char[5][5];
        char[][] player_two_target_history_board = new char[5][5];
        
        boolean gameOver = false;
        String winner = null; 

        // Prompt each players for 5 ship locations
        
        // Player One--------------
        System.out.println("\nPLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

        // Get all 5 ships (locations)        
        for (int count = 0;count<5;count++){
            player_one_ships[count] = getShip(scanner, player_one_ships, count);
        }

        // Build P1's Location Board
        player_one_location_board = emptyBoard(player_one_location_board);

        // Build P1's Target History Board 
        player_one_target_history_board = emptyBoard(player_one_target_history_board);

        // Add starting ship locations
        player_one_location_board = addShipsToBoard(player_one_location_board, player_one_ships);
        printBattleShip(player_one_location_board);

        // Cleanup
        clearScreen(scanner);

        // Player Two--------------
        System.out.println("\nPLAYER 2, ENTER YOUR SHIPS' COORDINATES.");

        // Get all 5 ships (locations)        
        for (int count = 0;count<5;count++){
            player_two_ships[count] = getShip(scanner, player_two_ships, count);
        }

        // Build P1's Location Board
        player_two_location_board = emptyBoard(player_two_location_board);

        // Build P2's Target History Board 
        player_two_target_history_board = emptyBoard(player_two_target_history_board);

        // Add starting ship locations
        player_two_location_board = addShipsToBoard(player_two_location_board, player_two_ships);
        printBattleShip(player_two_location_board);
        
        // Clear Screen
        clearScreen(scanner);

        // Begin Attacks
        int[] attack = new int[2];
        int current_player = 1;

        boolean hit = false; 

        // Loop through attacks, until the game is over
        do{;

            // Player 1's Turn
            if (current_player == 1 ){
                System.out.println("Player 1, enter hit row/column:");

                // Get attack coordinates
                attack = getAttack(scanner, player_two_target_history_board);

                // Plot Attack on target_history_board
                hit = hitOrMiss(player_two_ships, attack);

                // Plot the hit or miss
                if (hit){
                    System.out.println("PLAYER " + current_player + " HIT PLAYER 2's SHIP!");
                    player_two_target_history_board[attack[0]][attack[1]] = 'X';
                }else{
                    System.out.println("PLAYER " + current_player + " MISSED!");
                    player_two_target_history_board[attack[0]][attack[1]] = 'O';
                }

                printBattleShip(player_two_target_history_board);

                // Check if that attack won the game
                gameOver = checkForWin(player_two_target_history_board, player_two_ships);

                // Assign Winner if there is one
                if (gameOver){
                    System.out.println("PLAYER" + current_player + " WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                }

                // Switch to player 2 
                current_player = 2;
            }

            // Player Two's turn
            else{ 
                System.out.println("Player 2, enter hit row/column:");

                // Get attack coordinates
                attack = getAttack(scanner, player_one_target_history_board);

                // Plot Attack on target_history_board
                hit = hitOrMiss(player_one_ships, attack);

                // Plot the hit or miss
                if (hit){
                    System.out.println("PLAYER " + current_player + " HIT PLAYER 1's SHIP!");
                    player_one_target_history_board[attack[0]][attack[1]] = 'X';
                }else{
                    System.out.println("PLAYER " + current_player + " MISSED!");
                    player_one_target_history_board[attack[0]][attack[1]] = 'O';
                }

                printBattleShip(player_one_target_history_board);

                // Check if that attack won the game
                gameOver = checkForWin(player_one_target_history_board, player_one_ships);

                // Assign Winner if there is one
                if (gameOver){
                    System.out.println("PLAYER" + current_player + " WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                }

                // Switch to player 1 
                current_player = 1;
            }
            

        } while (gameOver == false);

    }

    public static int[] getCoordinates(Scanner scanner, int num_ship){
        // Define coords variable
        int coords[] = new int[2];
        
        // Keep prompting until valid input is received
        while (true) {
            try {
                if(!(num_ship == -1)){
                    System.out.println("Enter Ship " + num_ship + " location: ");
                }
                // Check for valid ints
                if (scanner.hasNextInt()) {
                    coords[0] = scanner.nextInt();
                } else {
                    scanner.nextLine();  // Clear the invalid input
                    throw new InputMismatchException("Invalid input.");
                }
                
                if (scanner.hasNextInt()) {
                    coords[1] = scanner.nextInt();
                } else {
                    scanner.nextLine();  // Clear the invalid input
                    throw new InputMismatchException("Invalid input.");
                }
                
                // Check that they are in range
                if ( ! (coords[0] < 5 && coords[0] > -1) || ! (coords[1] < 5 && coords[1] > -1)){
                    throw new InputMismatchException("Invalid input.");
                }
                scanner.nextLine();  // Clear the rest of the line
                return coords;
            } catch (InputMismatchException e) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                // The loop will continue, prompting the user again
            } 
        }
    }

    public static int[] getShip(Scanner scanner, int[][] ships, int count){
        int[] new_coords = new int[2];
        new_coords = getCoordinates(scanner, count);

        int other_ships = count;
        // Check against other ships
        do{
            if(new_coords[0] == ships[other_ships][0] && new_coords[1]  == ships[other_ships][1]){
                System.out.println("You already have a ship there. Choose different coordinates.");
                new_coords = getCoordinates(scanner, count);
            
            }
            other_ships = other_ships - 1;
        } while (other_ships>=0);

        return new_coords;
    }

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

    public static char[][] emptyBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }

    public static char[][] addShipsToBoard(char[][] board, int[][] ships) {
        for (int i = 0; i < ships.length; i++) {
            board[ships[i][0]][ships[i][1]] = '@';
        }
        return board;
    }

    public static void clearScreen(Scanner scanner){
        
        // Promt user to clear screen
        //System.out.println("Press Enter to continue...");
        //scanner.nextLine();  // Wait for the user to enter something

        // Clear Screen
        for (int i = 0; i < 100; i++) {
            System.out.println();  // Print a blank line
        }
    }

    public static int[] getAttack(Scanner scanner, char[][] player_target_history_board ){
        int[] new_attack = new int[2];
        new_attack = getCoordinates(scanner, -1);

        // DEBUG
        System.out.println("Firing at location: " + new_attack[0] + " " + new_attack[1]);
        System.out.println("This location currently has status: " + player_target_history_board[new_attack[0]][new_attack[1]] );
        // Check if coordinates of attack was already chosen
        if( player_target_history_board[new_attack[0]][new_attack[1]] == '-'){
            return new_attack;
        }
        else{
            // If the space is not empty, have them try again until they provide a location they have not chosen yet.
            System.out.println("You already fired on this spot. Choose different coordinates.");          
            return getAttack(scanner, player_target_history_board);
        }

    }

    private static boolean hitOrMiss(int[][] player_ships, int[] attack){
        boolean hit = false;

        // If the attack coordinates match any of the player's ship coordinates, its a hit
        for (int i = 0; i < player_ships.length; i++) {
            if(attack[0] == player_ships[i][0] && attack[1] == player_ships[i][1]){
                hit = true;
                break;
            }
        }

        return hit;

    }

    private static boolean checkForWin(char[][] player_target_history_board, int[][] player_ships){
        for (int i = 0; i < player_ships.length; i++) {

            // If any of the ships are not marked hit on the target history board, its not a win
            if(! (player_target_history_board[player_ships[i][0]][player_ships[i][1]] == 'X')){
                return false;
            }
        }

        // If all ships were hit, return 1
        return true;
    }

}