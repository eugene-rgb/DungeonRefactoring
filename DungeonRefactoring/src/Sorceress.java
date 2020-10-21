
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero {
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
	public int getMIN_ADD() {
		return MIN_ADD;
	}

	public int getMAX_ADD() {
		return MAX_ADD;
	}


//-----------------------------------------------------------------
	public Sorceress(final SkillStrategy skillStrat) {
		super("Sorceress", 75, 5, .7, 25, 50, .3, skillStrat);

	}// end constructor

	
//-----------------------------------------------------------------
	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method

//-----------------------------------------------------------------
	@Override
	public void battleChoices(DungeonCharacter opponent) {
		int choice;

		super.battleChoices(opponent);

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. " + this.skillStrategy.getSkillName());
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				skillStrategy.useSkill(this, opponent);
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