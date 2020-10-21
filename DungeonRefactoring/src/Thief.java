
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Thief extends Hero {

	public Thief(final SkillStrategy skillStrat) {
		super("Thief", 75, 6, .8, 20, 40, .4, skillStrat);

	}// end constructor

	@Override
	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;

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
				this.skillStrategy.useSkill(this, opponent);
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0 && opponent.isAlive() && this.isAlive());

	}
}