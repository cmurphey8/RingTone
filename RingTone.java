//************************************************************************
//  File: RingTone.java
//************************************************************************

public class RingTone {
    private double[] rb;        // items in the buffer
    private int bufferSize;     // buffer item capacity

    private int first;          // index for the next dequeue
    private int last;           // index for the next enqueues

    // CONSTRUCTOR
    // load RingTone buffer object with a SINE WAVE at the given frequency
    public RingTone(double hz) {

        // buffer index tracking
        first = 0;
        last = 0;

        // YOU DO: sample a full period of the SINE WAVE made by the input frequency
        double numSamples = StdAudio.SAMPLE_RATE / hz; // eg, 100.2
        bufferSize = (int) Math.round(numSamples);     // eg, 100

        rb = new double[bufferSize];

        for (int i = 0; i < bufferSize; i++) {

            double s = i * numSamples/bufferSize;
            // the SINE WAVE made by the input frequency
            this.enqueue(Math.sin(2 * Math.PI * s * hz / StdAudio.SAMPLE_RATE));
		}
    }

    // WE DO: play this RingTone for the specified duration
    public void playTone(double duration) {

        // WE DO: total number of samples to play in the specified duration
		int N = (int) (StdAudio.SAMPLE_RATE * duration);

		for (int i = 1; i <= N; i++) {

            // WE DO: dequeue a sample from this RingTone
			double quanta = this.dequeue();

            // WE DO: enqueue the sample back into the buffer @ .98 amplitude
            this.enqueue(quanta * .98);

            // WE DO: play the sample
			StdAudio.play(quanta);
		}
	}

    // YOU DO: add item x to index <last> and update index
    private void enqueue(double x) {
        rb[last] = x;
        last = (last + 1) % rb.length;
    }

    // YOU DO: return item from index <first> and update index
    private double dequeue() {
        double ret = rb[first];
        first = (first + 1) % rb.length;
        return ret;
    }
}