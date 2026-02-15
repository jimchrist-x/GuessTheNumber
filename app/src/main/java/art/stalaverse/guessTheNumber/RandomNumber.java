package art.stalaverse.guessTheNumber;

import java.util.Random;

public class RandomNumber {
	private final int rangeLow=0;
	private final int rangeHigh=100;
	private final long seed=System.currentTimeMillis();
	private final Random generator=new Random(seed);
	public static int get() {
		return (generator.nextInt(rangeHigh-rangeLow)+rangeLow);
	}
}
