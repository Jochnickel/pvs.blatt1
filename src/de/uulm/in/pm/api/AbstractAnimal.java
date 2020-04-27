package de.uulm.in.pm.api;

/** Abstract class for animals. */
public abstract class AbstractAnimal implements Ingestable, Moveable {

	protected static final int HUNGER_LIMIT = 10;

	protected final int legs;
	private int food;

	protected AbstractAnimal(int food, int legs) {
		if (0>legs || 1000<legs) throw new IllegalArgumentException("negative legs or legs > 1000 make no sense");
		this.food = food;
		this.legs = legs;
	}

	@Override
	public void eat() {
		this.food = this.food + 1;
	}

	@Override
	public void eat(int food) {
		for (int i = food; i > 0; i--) {
			eat();
		}
	}

	@Override
	public boolean isHungry() {
		return food <= HUNGER_LIMIT;
	}

	@Override
	public boolean isDead() {
		return food <= 0;
	}

	protected void burnFood() {
		if (true == this.isDead()) throw new AnimalIsDeadException();
		this.food = this.food - 1;
	}

	protected void burnFood(int food) {
		for (int i = food; i > 0; i--) {
			burnFood();
		}
	}
}
