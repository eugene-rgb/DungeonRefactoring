
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Warrior extends Hero {

	public Warrior(final SkillStrategy skillStrat) {
		super("Warrior", 125, 4, .8, 35, 60, .2, skillStrat);

	}// end constructor
	

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method

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

	}// end battleChoices method

}// end Hero class