package de.uulm.in.pm.api;

/** Bird that can do stuff. */
public final class Eagle extends AbstractBird implements BirdOfPrey {

	protected static final int HUNTED_FOOD_VALUE = 10;
	protected static final int TAKEOFF_FOOD_COST = 3;
	protected final String name;

	public Eagle(int food, String name) {
		super(food, 2);
		this.name = name;
	}

	public Eagle(int legs, int food, String name){
		super(food, legs, 2);
		this.name = name;
	}

	@Override
	public void hunt() {
		takeOff();
		move();
		land();
		eat(HUNTED_FOOD_VALUE);
	}

	@Override
	public void land() {
		burnFood();
		super.land();
	}

	@Override
	public void takeOff() {
		burnFood(TAKEOFF_FOOD_COST);
		super.takeOff();
	}

	@Override
	public void move() {
		burnFood();
	}

	public String toString(){
		return "[Eagle " + this.hashCode() + "]: " + this.name;
	}

	public boolean equals(Eagle e2){
		// assert(null!=this.name);
		// assert(null!=e2.name);
		if (this.name==null) throw new NullPointerException("This Eagle dosn't have a name.");
		return this.name.equals(e2.name);
	}
}
