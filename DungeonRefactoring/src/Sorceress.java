
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero {
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

//-----------------------------------------------------------------
	public Sorceress() {
		super("Sorceress", 75, 5, .7, 25, 50, .3);

	}// end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints() {
		int hPoints;

		hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		this.addHitPoints(hPoints);
		System.out.println(
				this.name + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + this.hitPoints);
		System.out.println();

	}// end increaseHitPoints method

//-----------------------------------------------------------------
	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method

//-----------------------------------------------------------------
	@Override
	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. Increase Hit Points");
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				increaseHitPoints();
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0 && this.isAlive() && opponent.isAlive());

	}// end overridden method

}// end class