package de.uulm.in.pm.test;

import java.util.ArrayList;
import java.util.List;

import de.uulm.in.pm.api.AnimalIsDeadException;
import de.uulm.in.pm.api.Eagle;

/** Main class. */
public class Main {

	/** Run tests. */
	public static void main(String[] args) {
		// AbstractBird tweety = new AbstractBird(100, 2);
		Eagle amos = new Eagle(100, "Amos");
		System.out.println(amos);
		Eagle amos2 = new Eagle(100, "Amos");
		System.out.println("amos == amos2 | " + (amos == amos2));
		System.out.println("amos.equals(amos2) | " + amos.equals(amos2));
		try {
			@SuppressWarnings("unused")
			Eagle noBird = new Eagle(-1, 2, "Harald");
		} catch (IllegalArgumentException e) {
			// System.out.println(e);
			System.out.println("Test passed :) | (-1)-legged Bird indeed not creatable");
		}
		try {
			Eagle hungryBird = new Eagle(2, "Fritz");
			hungryBird.move();
			hungryBird.move();
			hungryBird.move();
		} catch (AnimalIsDeadException e) {
			// System.out.println(e);
			System.out.println("Test passed :) | Bird is dead");
		}
		
		List<Eagle> aviary = new ArrayList<Eagle>();
		Eagle anyEagle;
		aviary.add(new Eagle(100, "Brutus"));
		aviary.add(new Eagle(100, "Chronos"));
		
		for(int i = 0; i<aviary.size(); i++){
			anyEagle = aviary.get(i);
			anyEagle.hunt();
		}
	}
}
