package GuitarHeroine;

import java.util.Random;

public class GuitarString {

	private double samplingRate = 44100;
	private RingBuffer buffer;
	private int ticCount = 0;
	private double energyDecayFactor = 0.99;

	public GuitarString(double frequency) {
		int x = (int) (Math.round(samplingRate / frequency));
		buffer = new RingBuffer(x);
		for (int i = 0; i < x; i++) {
			buffer.enqueue(0);
		}
	}

	public void pluck() {
		Random rand = new Random();
		for (int i = 0; i < buffer.getCapacity(); i++) { // maybe not size
			buffer.dequeue();
		}
		for (int i = 0; i < buffer.getCapacity(); i++) {
			double x = rand.nextDouble() - 0.5;
			buffer.enqueue(x);
		}
	}

	public void tic() {
		double sampleOne = buffer.dequeue();
		double sampleTwo = buffer.peek();
		double newSample = energyDecayFactor * (0.5 * (sampleOne + sampleTwo));
		buffer.enqueue(newSample);
		ticCount++;
	}

	public double sample() {
		return buffer.peek();
	}

	public int time() {
		return ticCount;
	}

}
