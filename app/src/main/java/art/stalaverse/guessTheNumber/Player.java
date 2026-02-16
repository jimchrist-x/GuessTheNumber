package art.stalaverse.guessTheNumber;

import java.util.List;
import java.util.ArrayList;
public class Player {
	private int guesses=0;
	public int getGuesses() {
		return guesses;
	}
	public void incrementGuesses() {
		this.guesses++;
	}
}