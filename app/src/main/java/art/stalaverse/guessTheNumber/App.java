package art.stalaverse.guessTheNumber;

import java.util.Scanner;

enum Options {
	PLAY, RULES, EXIT, ERROR;
}
public class App {
	final static int lineSize=60;
	public static void printLine(int size) {
		System.out.println("=".repeat(size));
	}
	public static void main(String[] args) {
		RandomNumber number=new RandomNumber();
		Scanner reader=new Scanner(System.in);
		// Menu
		Options choice;
		do {
			printLine(lineSize);
			System.out.println("[1] PLAY");
			System.out.println("[2] RULES");
			System.out.println("[3] EXIT");
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
					break;
				case RULES:
					break;
				case EXIT:
					break;
				case ERROR:
					break;
			}
		} while (choice!=Options.EXIT);
	}
}
