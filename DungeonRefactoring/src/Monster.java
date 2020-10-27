
/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class Monster extends DungeonCharacter {
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

//-----------------------------------------------------------------
	public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;

	}// end monster constructor
	
	//added this method to allow functionality of MonsterPointModifier class (Collin)
	public double getChanceToHeal() {
		return chanceToHeal;
	}

//-----------------------------------------------------------------

	//the heal method was moved to the MonsterPointModifier class as it is the only class that will be using the method (Collin)

//-----------------------------------------------------------------

	//the subtractHitPoints method was also moved to the MonsterPointModifier class to encapsulate all hit point manipulation there (Collin)

}// end Monster class