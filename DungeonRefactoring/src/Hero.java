public abstract class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;
	private SkillStrategy skillStrategy;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, SkillStrategy skillStrat) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		readName();
		
		if (skillStrat != null) {
			this.skillStrategy = skillStrat;
		} else {
			throw new IllegalArgumentException("SkillStrategy object NULL @ Hero constructor");
		}
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
	
	////added this method to allow for functionality of the HeroPointModifier class (Collin)
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


	/*
	 * This is a new method created for the sole purpose of calculating the number of turns 
	 * a Hero has during a match. Previously, Heroes would override battleChoices() but use 
	 * the base-class method to calculate the number of turns. With the new implementation, 
	 * it's more clear what's happening and more flexible. The way in which the calculation 
	 * of turns is performed is exactly the same as before.
	 * 
	 */
	public void calculateTurns(final DungeonCharacter opponent) {
		if (opponent == null) {
			throw new IllegalArgumentException("Opponent NULL @ Hero's calculateTurns() method");
		}
		
		this.numTurns = this.attackSpeed / opponent.getAttackSpeed();
		
		if (this.numTurns == 0)
			this.numTurns++;
		
		System.out.println("Number of turns this round is: " + this.numTurns);
	}
	
	/*
	 * This is the original battleChoices() method, but reworked into a polymorphic method--
	 * this method doesn't know or care which Strategy/"Algorithm" it receives at runtime. 
	 * Such refactoring reduces WET code and increases behavior flexibility. 
	 * 
	 * This method is called from the Arena by the Hero and displays/uses the attack options 
	 * available to the Hero.
	 * 
	 * If the Hero doesn't receive a special skill-Strategy at runtime, a second attack 
	 * option isn't displayed and the default attack is the only choice given. The do-while 
	 * conditional has been tweaked for better readability: the isAlive() method has been employed.
	 * 
	 */
	public void battleChoices(DungeonCharacter opponent) {
		if (opponent == null) {
			throw new IllegalArgumentException("Opponent NULL @ Hero battleChoice() method");
		}
		
		int choice;
		calculateTurns(opponent);

		do {
			System.out.println("1. Attack Opponent");
			
			if (this.skillStrategy != null) {
				System.out.println("2. " + this.skillStrategy.getSkillName());
			}
			
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			switch (choice) {
			case 1:
				attack(opponent);
				this.numTurns--;
				break;
			case 2:
				
				try {
					this.skillStrategy.useSkill(this, opponent);
				} catch (NullPointerException e) {
					System.out.println("Hero didn't have recieve a special skill, defaulting to a regular attack.");
					this.attack(opponent);
				}
				this.numTurns--;
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			if (this.numTurns > 0 && this.isAlive() && opponent.isAlive())
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (this.numTurns > 0 && opponent.isAlive() && this.isAlive());

	}
	

}// end Hero class