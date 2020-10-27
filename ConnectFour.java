import java.util.Scanner;

public class ConnectFour { // ADDING COMMENT AS CHANGE FOR GITHUB



    public static void main(String[] args) {
        System.out.println("Changed Something");


        Scanner scnr = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be?");
        int height = scnr.nextInt(); // user defines height of board
        System.out.println("What would you like the length of the board to be?");
        int length = scnr.nextInt(); // user defines length of board

        char[][] board = new char[height][length]; // declare 2D array board based on user input
        initializeBoard(board);
        printBoard(board);

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        boolean check1 = false;
        boolean check2 = false;
        int boardSize = length * height;
        int boardCount = 0;

        while (!check1 && !check2) {

            System.out.println("Player 1: Which column would you like to choose? "); // loop for P1, inside loop add chip and check for win
            int col1 = scnr.nextInt();
            char player1 = 'x';
            int gameRow = insertChip(board, col1, player1);
            printBoard(board);
            boardCount ++;

            check1 = checkIfWinner(board, col1, gameRow, player1); // check win after each turn
            if (check1) {
                System.out.print("Player 1 won the game!");
                break;
            }
            if (boardCount == boardSize) {
                System.out.println("Draw. Nobody wins.");
                break;
            }


            System.out.println("Player 2: Which column would you like to choose? ");
            int col2 = scnr.nextInt();
            char player2 = 'o';
            int gameRow2 = insertChip(board, col2, player2);
            printBoard(board);
            boardCount ++;


            check2 = checkIfWinner(board, col2, gameRow2, player2);
            // parameters: char[][] array, int col, int row, char chipType

            if (check2) {
                System.out.print("Player 2 won the game!");
                break;
            }
            if (boardCount == boardSize) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
            }

        }






    public static void printBoard(char[][] array) {
        for (int i = array.length-1; i >= 0; i --) {
            System.out.println();
            for (int j = 0; j < array[0].length; j++) {

                System.out.print(array[i][j]);




            } }
  }

    public static void initializeBoard(char[][]array) { //This will set each spot in the array to “-”.

        for (int i = array.length-1; i >= 0; i --) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';


            } }


    }
    // Will find the next available spot in that column
    // if there are already tokens there. The row that the token is placed in is returned.
    public static int insertChip(char[][]array, int col, char chipType) { //Places the token in the column that the user has chosen.
        int row = 0;

        for (int i = 0; i < array.length; i ++) {
            if ((array[i][col] == 'x') || (array[i][col] == 'o')) {
                row ++;

            }
            else {
                break;
            } }

        array[row][col] = chipType; //error?
        return row;

    }


    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        int countV = 0;
        int countH = 1;


        //check vertical
        // check everything below it
       //  one iterating through the column , one through row


        for (int i = 0; i < array.length; i++) { // iterates across the number of rows (height)
            if ((array[i][col] == chipType)) { // checks for matches
                countV++;
            }
            else {
                countV = 0;
            }

        if (countV >= 4) { // if there
            return true;
        }


        }

// check horizontal

    for (int j = 0; j < array[row].length - 1; j ++) { // iterate through different columns (length)
        if ((array[row][j] == array[row][j + 1]) && (array[row][j] != '-')) { //if there is a consecutive match of 4 'x' or 'o', give win
            countH ++; }
        else {
            countH = 1;
        }

        if (countH >= 4) {
            return true;
        }
    }

//                }

return false;
    }

}
