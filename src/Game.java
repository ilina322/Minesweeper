import java.util.Random;
import java.util.Scanner;

public class Game {

	static Scanner consoleReader = new Scanner(System.in);
	
	private static final char BOMB_SYMBOL = '*';
	private static final char MARKED_SYMBOL = '#';
	private static final char UNOPENED_SYMBOL = '-';
	private static int height;
	private static int length;
	private static char[][] board;
	private static boolean[][] bombBoard;
	private static boolean isGameRunning = true;
	private static int bombNumber;

	public static void main(String[] args) {

		getGameParametresFromUser();
		generateBombs();
		createNewBoard();
		printBoard();

		while (isGameRunning) {
			handleCommandInput();
			printBoard();
		}
	}

	private static void generateBombs() {
		Random rand = new Random();
		for (int generatedBombs = 0; generatedBombs < board.length; generatedBombs++) {
			int x = rand.nextInt(length);
			int y = rand.nextInt(height);
			while(isBomb(x, y)) {
				x = rand.nextInt(length);
				y = rand.nextInt(height);
			}
			bombBoard[x][y] = true;
		}
	}

	private static boolean isBomb(int x, int y) {
		return bombBoard[x][y];
	}

	private static void handleCommandInput() {
		String command = readCommandFromUser();

		// Parsing command
		char[] commandArray = command.toCharArray();
		int currX = Integer.parseInt(commandArray[0] + "");
		int currY = Integer.parseInt(commandArray[2] + "");
		char currAction = commandArray[4];

		executeCommand(currX, currY, currAction);
	}

	private static void executeCommand(int currX, int currY, char currAction) {

		if (currAction == 'm') {
			board[currX][currY] = MARKED_SYMBOL;
		}
		if (currAction == 'o') {
			board[currX][currY] = BOMB_SYMBOL;
			isGameRunning = false;
		}

	}

	private static String readCommandFromUser() {
		System.out.println("Enter command: ");
		String command = consoleReader.nextLine();
		return command;
	}

	private static void printBoard() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < length; x++) {
				System.out.print(board[x][y]);
			}
			System.out.println();
		}
	}

	private static void createNewBoard() {
		board = new char[length][height];
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				board[x][y] = UNOPENED_SYMBOL;
			}
		}
	}

	private static void getGameParametresFromUser() {
		System.out.print("Enter height: ");
		height = consoleReader.nextInt();
		System.out.print("Enter length: ");
		length = consoleReader.nextInt();
		System.out.print("Enter bombs number: ");
		bombNumber = consoleReader.nextInt();
		consoleReader.nextLine();
	}

}
