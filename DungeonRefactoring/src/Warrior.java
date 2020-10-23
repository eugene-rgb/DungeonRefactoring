
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
	

	// This is getting overridden only for the custom message "swings a mighty sword"
	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(this.name + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method

}// end Hero class