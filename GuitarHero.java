package GuitarHeroine;

import java.util.ArrayList;

public class GuitarHero {

	public static void main(String[] args) {
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		ArrayList<GuitarString> strings = new ArrayList<>();
		for (int i = 0; i < keyboard.length(); i++) {
			strings.add(new GuitarString(440 * Math.pow(1.05956, i - 24)));

		}
		while (true) {
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				if (keyboard.contains(key + "")) {
					int index = keyboard.indexOf(key);
					strings.get(index).pluck();
				}
			}
			double sample = 0;
			for (GuitarString string : strings) {
				sample += string.sample();
				string.tic();
			}
			StdAudio.play(sample);
		}
	}
}
