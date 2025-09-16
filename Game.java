import java.util.*;
public class Game {

    static String[] board;
    static String turn;

    public static String checkWinner(){     //CheckWinner method to decide the Winner
        for(int i =0;i<8;i++){
            String line =null;

            switch(i){
                case 0:
                    line = board[0]+board[1]+board[2];
                    break;
                case 1:
                    line = board[3]+board[4]+board[5];
                    break;
                case 2:
                    line = board[6]+board[7]+board[8];
                    break;
                case 3:
                    line = board[0]+board[3]+board[6];
                    break;
                case 4:
                    line = board[1]+board[4]+board[7];
                    break;
                case 5:
                    line = board[2]+board[5]+board[8];
                    break;
                case 6:
                    line = board[0]+board[4]+board[8];
                    break;
                case 7:
                    line = board[2]+board[4]+board[6];
                    break;
            }
            //For X Winner
            if(line.equals("XXX")){
                return "X";
            }
            //For O Winner
            else if(line.equals("OOO")){
                return "O";
            }
        }
        for(int i =0;i<9;i++){
            if(Arrays.asList(board).contains(String.valueOf(i+1))){
                break;
            } else if(i==8){
                return "draw";
            }
        }
        System.out.println(turn+"'s turn; Enter a slot Number to place😊 "+ turn+" int: ");
            return null;
    }

    //To print the board:
    public static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| "+ board[0]+" | "+ board[1]+" | "+ board[2]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+ board[3]+" | "+ board[4]+" | "+ board[5]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+ board[6]+" | "+ board[7]+" | "+ board[8]+" | ");
        System.out.println("|---|---|---|");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new String[9];
        turn = "X" ;
        String winner = null;

        for(int i=0;i<9;i++){
            board[i]= String.valueOf(i+1);
        }
        System.out.println("\t\tWelcome to Tic-Tac-Toe Game 🧒🧒");
        printBoard();
        System.out.println("X will play first🧑\tPlease Enter a slot number to place X in:");


        while(winner ==null) {
            int numInput;
            try {
                numInput = sc.nextInt();

                //Checking the range
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input🤷‍♂️, Please re-enter slot number: ");
                    continue;
                }
                // To check if the slot is available
                if (board[numInput - 1].equals(String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    //Toggle turn
                    turn = turn.equals("X") ? "O" : "X";

                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println("Slot already taken🤷‍♂️, Please re-enter slot number: ");
                }

            }
            catch(InputMismatchException e){
                System.out.println("Invalid input🤷‍♂️, Please re-enter slot number: ");
                sc.nextLine();
              }
        }

        //Final Result:
        if(winner.equalsIgnoreCase("Draw")){
            System.out.println("It is a DRAW!!🤡\nThanks for Playing.");
        } else{
            System.out.println("Congratulations!!🎉🎉 "+winner+"'s has won!\nThanks for Playing.");
        }

    sc.close();
    }
}
