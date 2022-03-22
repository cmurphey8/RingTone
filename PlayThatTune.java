
/*************************************************************************
 *  Compilation:  javac PlayThatTune.java
 *  Execution:    java PlayThatTune input.txt
 *  Dependencies: RingTone.java StdAudio.java
 *
 *  This is a data-driven program that plays pure tones from
 *  the notes on the chromatic scale, specified on standard input
 *  by their distance from concert A.
 *
 *  % java PlayThatTune elise.txt
 *
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *
 *************************************************************************/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

public class PlayThatTune {
	public static void main(String[] args) throws FileNotFoundException {
		// play song file read in from the first CLA
		playSong(args[0]);
	}
	
	public static void playSong(String fileName) throws FileNotFoundException {
		// init scanner
		Scanner console = new Scanner(new File(fileName));

		// repeat as long as there are more integers to read in
		while (console.hasNextInt()) {

			// read in the pitch, where 0 = Concert A (A4)
			int pitch = console.nextInt();

			// read in duration in seconds
			double duration = 1.5 * console.nextDouble();

			// compute desired frequency
			double hz = 440 * Math.pow(2, pitch / 12.0);

			// build and play the tone
			RingTone tone = new RingTone(hz);
			tone.playTone(duration);

		}
		// close scanner
		console.close();
	}
}
