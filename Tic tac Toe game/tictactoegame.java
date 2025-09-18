import java.util.*;

public class tictactoegame {

    private char[] board = new char[10];  // 0th index ignored
    private char playerLetter, computerLetter;
    private String currentTurn;

    // UC1: Create board
    public void createBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    // UC2: Allow player to choose X or O
    public void choosePlayerLetter() {
        Scanner sc = new Scanner(System.in);
        char letter;
        while (true) {
            System.out.print("Choose your letter (X or O): ");
            letter = sc.next().toUpperCase().charAt(0);
            if (letter == 'X' || letter == 'O') {
                playerLetter = letter;
                computerLetter = (letter == 'X') ? 'O' : 'X';
                System.out.println("Player: " + playerLetter + " | Computer: " + computerLetter);
                break;
            } else {
                System.out.println("Invalid choice! Please choose X or O.");
                sc.close();
            }
        }
    }

    // UC3: Show Board
    public void showBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
        System.out.println("-------------");
    }

    // UC4 + UC5: Make Move
    public boolean isFreeSpace(int index) {
        return board[index] == ' ';
    }

    public void makeMove(int index, char letter) {
        if (isFreeSpace(index)) {
            board[index] = letter;
        }
    }

    // UC6: Toss
    public void tossToDecideTurn() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            currentTurn = "Player";
        } else {
            currentTurn = "Computer";
        }
        System.out.println(currentTurn + " will play first.");
    }

    // UC7: Check Winner
    public boolean isWinner(char letter) {
        return (board[1] == letter && board[2] == letter && board[3] == letter) ||
               (board[4] == letter && board[5] == letter && board[6] == letter) ||
               (board[7] == letter && board[8] == letter && board[9] == letter) ||
               (board[1] == letter && board[4] == letter && board[7] == letter) ||
               (board[2] == letter && board[5] == letter && board[8] == letter) ||
               (board[3] == letter && board[6] == letter && board[9] == letter) ||
               (board[1] == letter && board[5] == letter && board[9] == letter) ||
               (board[3] == letter && board[5] == letter && board[7] == letter);
    }

    public boolean isBoardFull() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') return false;
        }
        return true;
    }

    // --- COMPUTER STRATEGY (UC8 - UC11) ---
    public int getComputerMove() {
        // UC8: Can computer win?
        for (int i = 1; i <= 9; i++) {
            if (isFreeSpace(i)) {
                board[i] = computerLetter;
                if (isWinner(computerLetter)) {
                    board[i] = ' ';
                    return i;
                }
                board[i] = ' ';
            }
        }

        // UC9: Can player win next? Block it.
        for (int i = 1; i <= 9; i++) {
            if (isFreeSpace(i)) {
                board[i] = playerLetter;
                if (isWinner(playerLetter)) {
                    board[i] = ' ';
                    return i;
                }
                board[i] = ' ';
            }
        }

        // UC10: Take one of the corners if free
        int[] corners = {1, 3, 7, 9};
        for (int corner : corners) {
            if (isFreeSpace(corner)) {
                return corner;
            }
        }

        // UC11: Take center if free
        if (isFreeSpace(5)) {
            return 5;
        }

        // UC11: Take sides
        int[] sides = {2, 4, 6, 8};
        for (int side : sides) {
            if (isFreeSpace(side)) {
                return side;
            }
        }

        return -1; // should never happen if called properly
    }

    // UC12: Play Game
    public void playGame() {
        Scanner sc = new Scanner(System.in);
        createBoard();
        choosePlayerLetter();
        tossToDecideTurn();

        boolean gameOver = false;

        while (!gameOver) {
            showBoard();

            if (currentTurn.equals("Player")) {
                System.out.print("Enter your move (1-9): ");
                int move = sc.nextInt();
                if (move >= 1 && move <= 9 && isFreeSpace(move)) {
                    makeMove(move, playerLetter);
                    if (isWinner(playerLetter)) {
                        showBoard();
                        System.out.println("🎉 Player Wins!");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        showBoard();
                        System.out.println("It's a Tie!");
                        gameOver = true;
                    } else {
                        currentTurn = "Computer";
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } else { // Computer's turn
                int move = getComputerMove();
                makeMove(move, computerLetter);
                System.out.println("Computer chose position " + move);

                if (isWinner(computerLetter)) {
                    showBoard();
                    System.out.println(" Computer Wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    showBoard();
                    System.out.println("It's a Tie!");
                    gameOver = true;
                } else {
                    currentTurn = "Player";
                    sc.close();
                }
            }
        }
    }

    // UC13: Ask user for replay
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            tictactoegame Game = new tictactoegame();
            Game.playGame();
        }

            System.out.print("Do you want to play again? (yes/no): ");
            String ans = sc.next().toLowerCase();
            if (!ans.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing Tic-Tac-Toe!");
                sc.close();
            }
        }
    }


