
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero {
	private final int MIN_HEAL = 25;
	private final int MAX_HEAL = 50;
	
	public int getMIN_HEAL() {
		return MIN_HEAL;
	}

	public int getMAX_HEAL() {
		return MAX_HEAL;
	}


//-----------------------------------------------------------------
	public Sorceress(final SkillStrategy skillStrat) {
		super("Sorceress", 75, 5, .7, 25, 50, .3, skillStrat);

	}// end constructor

	
//-----------------------------------------------------------------
	//Attack is getting overridden here to provide a custom message about the attack "casts a spell"
	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method



}// end class