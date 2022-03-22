//************************************************************************
//  File: RingTone.java
//************************************************************************

public class RingTone {
    private double[] rb;        // items in the buffer
    private int bufferSize;     // buffer item capacity

    private int first;          // index for the next dequeue
    private int last;           // index for the next enqueues

    // load RingTone buffer object with a SINE WAVE at the given frequency
    public RingTone(double hz) {

        // init buffer index tracking
        first = 0;
        last = 0;

        // sample a full period of the SINE WAVE made by the input frequency
        double numSamples = StdAudio.SAMPLE_RATE / hz; // eg, 100.2
        bufferSize = (int) Math.round(numSamples);     // eg, 100

	    // WE DO: load the ring buffer with a full period of samples from the SINE WAVE
        for (int i = 0; i < bufferSize; i++) {
		
	        // WE DO: divide full period of the SINE WAVE evenly between <bufferSize> steps
            
	        // WE DO: enqueue the SINE WAVE sample
	    }
    }

    // YOU DO: play this RingTone for the specified duration
    public void playTone(double duration) {

        // YOU DO: total number of samples to play in the specified duration
	    int N;

	    for (int i = 1; i <= N; i++) {

            // YOU DO: dequeue a sample from this RingTone
            double sample;

            // YOU DO: enqueue the sample back into the buffer @ .98 amplitude

            // YOU DO: play the sample
	    }
    }   

    // YOU DO: add item x to index <last> and update index
    private void enqueue(double x) {
    }

    // YOU DO: return item from index <first> and update index
    private double dequeue() {
        double ret;
        return ret;
    }
}
