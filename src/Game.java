import java.util.Scanner;

public class Game {

	private static final char UNOPENED_SYMBOL = '-';
	private static int height;
	private static int length;
	private static char[][] board;

	public static void main(String[] args) {

		getBoardSizeFromUser();

		createNewBoard();

	}

	private static void createNewBoard() {
		board = new char[length][height];
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				board[x][y] = UNOPENED_SYMBOL;
			}
		}
	}

	private static void getBoardSizeFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter height: ");
		height = input.nextInt();
		System.out.println("Enter length: ");
		length = input.nextInt();
	}

}
