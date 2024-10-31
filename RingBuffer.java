package GuitarHeroine;

public class RingBuffer {

	private int first;
	public int last;
	public int size;
	private double[] buffer;
	private int capacity;

	public RingBuffer(int capacity) {
		buffer = new double[capacity];
		this.capacity = capacity;
		first = 0;
		last = 0;
		size = 0;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size == capacity) {
			return true;
		}
		return false;
	}

	public void enqueue(double x) {
		if (isFull()) {
			throw new IllegalArgumentException("full buffer");
		} else {
			buffer[last] = x;
			last = (last + 1) % buffer.length;
			size++;
		}

	}

	public double dequeue() {
		double removed;
		if (isEmpty()) {
			throw new IllegalArgumentException("empty buffer");
		} else {
			removed = buffer[first];
			first = (first + 1) % buffer.length;
			size--;
		}
		return removed;
	}

	public double peek() {
		double front = 0; // what to return if empty?
		if (!isEmpty()) {
			front = buffer[first];
		}
		return front;
	}
}
