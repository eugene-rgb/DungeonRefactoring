
/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes. It is derived
 * from DungeonCharacter. A Hero has battle choices: regular attack and a
 * special skill which is defined by the classes derived from Hero.
 *
 * class variables (all are directly accessible from derived classes):
 * chanceToBlock -- a hero has a chance to block an opponents attack numTurns --
 * if a hero is faster than opponent, their is a possibility for more than one
 * attack per round of battle
 *
 * class methods (all are public): public Hero(String name, int hitPoints, int
 * attackSpeed, double chanceToHit, int damageMin, int damageMax, double
 * chanceToBlock) public void readName() public boolean defend() public void
 * subtractHitPoints(int hitPoints) public void battleChoices(DungeonCharacter
 * opponent)
 * 
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;
	public SkillStrategy skillStrategy;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, SkillStrategy skillStrat) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.skillStrategy = skillStrat;
		readName();
	}

	/*-------------------------------------------------------
	readName obtains a name for the hero from the user
	
	Receives: nothing
	Returns: nothing
	
	This method calls: nothing
	This method is called by: hero constructor
	---------------------------------------------------------*/
	public void readName() {
		System.out.print("Enter character name: ");
		this.name = Keyboard.readString();
	}// end readName method
	
	////added this method to allow for functionality of the HerpPointModifier class (Collin)
	public double getChanceToBlock() {
		return chanceToBlock;
	}

	/*-------------------------------------------------------
	defend determines if hero blocks attack
	
	Receives: nothing
	Returns: true if attack is blocked, false otherwise
	
	This method calls: Math.random()
	This method is called by: subtractHitPoints()
	---------------------------------------------------------*/
	
	////moved the defend method to the HeroPointModifier class as only hit point methods use it (Collin)

	/*-------------------------------------------------------
	subtractHitPoints checks to see if hero blocked attack, if so a message
	is displayed, otherwise base version of this method is invoked to
	perform the subtraction operation.  This method overrides the method
	inherited from DungeonCharacter promoting polymorphic behavior
	
	Receives: hit points to subtract
	Returns: nothing
	
	This method calls: defend() or base version of method
	This method is called by: attack() from base class
	---------------------------------------------------------*/
	
	////moved the Hero class subtractHitPoints method to the HeroPointModifier class (Collin)


	// This method calculates the number of turns the Hero has in an attack
	public void calculateTurns(final DungeonCharacter opponent) {
		this.numTurns = this.attackSpeed / opponent.getAttackSpeed();
		
		if (this.numTurns == 0)
			this.numTurns++;
		
		System.out.println("Number of turns this round is: " + this.numTurns);
	}
	/*-------------------------------------------------------
	It computes the number of turns a hero will get per round based on the opponent that is
	being fought.  The number of turns is reported to the user.  This stuff might
	go better in another method that is invoked from this one...
	
	Receives: opponent
	Returns: nothing
	
	This method calls: getAttackSpeed()
	This method is called by: external sources
	---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent) {
		int choice;
		calculateTurns(opponent);

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. " + this.skillStrategy.getSkillName());
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			switch (choice) {
			case 1:
				attack(opponent);
				numTurns--;
				break;
			case 2:
				this.skillStrategy.useSkill(this, opponent);
				numTurns--;
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0 && opponent.isAlive() && this.isAlive());

	}

}// end Hero class