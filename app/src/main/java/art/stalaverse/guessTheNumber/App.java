package art.stalaverse.guessTheNumber;

import java.util.Scanner;
import java.io.IOException;
enum Options {
	PLAY, RULES, EXIT, ERROR;
}
public class App {
	final static int lineSize=60;
	static Scanner reader = new Scanner(System.in);
	public static void printLine(int size) {
		System.out.println("=".repeat(size));
	}
	public static void pause() {
		System.out.println("Press Enter to Continue...");
		reader.nextLine();
	}
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("Error clearing screen!");
		}
	}
	public static void main(String[] args) {
		RandomNumber number=new RandomNumber();
		// Menu
		Options choice;
		do {
			clearScreen();
			printLine(lineSize);
			System.out.println("[1] PLAY");
			System.out.println("[2] RULES");
			System.out.println("[3] EXIT");
			printLine(lineSize);
			if (reader.hasNextInt()) {
				switch(Integer.parseInt(reader.nextLine().trim())) {
					case 1:
						choice=Options.PLAY;
						break;
					case 2:
						choice=Options.RULES;
						break;
					case 3:
						choice=Options.EXIT;
						break;
					default:
						choice=Options.ERROR;
						break;
				}
			}
			else {
				choice=Options.ERROR;
			}
			switch (choice) {
				case PLAY:
					boolean isFound=false;
					clearScreen();
					Player player=new Player();
					int num=number.get();
					do {
						System.out.printf("Enter number (%d-%d): ", number.getRangeLow(), number.getRangeHigh());
						if (reader.hasNextInt()) {
							int guess=Integer.parseInt(reader.nextLine().trim());
							if (guess>num) {
								System.out.println("Lower!");
								player.incrementGuesses();
							}
							else if (guess<num) {
								System.out.println("Higher!");
								player.incrementGuesses();
							}
							else {
								isFound=true;
							}
						}
					} while (!isFound);
					clearScreen();
					printLine(lineSize);
					System.out.println("It took you " + player.getGuesses() + " guesses to find the number!");
					printLine(lineSize);
					pause();
					break;
				case RULES:
					clearScreen();
					break;
				case EXIT:
					break;
				case ERROR:
					break;
			}
		} while (choice!=Options.EXIT);
	}
}
