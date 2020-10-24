
public class Arena {
	
	/*-------------------------------------------------------------------
	battle is the actual combat portion of the game.  It requires a Hero
	and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	goes first, then the Monster.  At the conclusion of each round, the
	user has the option of quitting.
	---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster) {
		
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		// do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
			// hero goes first
			theHero.battleChoices(theMonster);

			// monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			// let the player bail out if desired
			if (theHero.isAlive() && theMonster.isAlive()) {
				System.out.print("\n-->q to quit, anything else to continue: ");
				pause = Keyboard.readChar();
			} // end of if statement 

		} // end battle loop

		//TO-DO refactor the code below to display before end game choice
		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else// both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}// end battle method
	
	/*-------------------------------------------------------------------
	chooseHero allows the user to select a hero, creates that hero, and
	returns it.  It utilizes a polymorphic reference (Hero) to accomplish
	this task
	---------------------------------------------------------------------*/
	public static Hero chooseHero() {
		int choice;
		
		// Hero theHero; NOTE: Apparenetly this is not being used? 

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		choice = Keyboard.readInt();

		switch (choice) {
		case 1:
			return new Warrior(new CrushingBlowSkillStrategy());

		case 2:
			return new Sorceress(new IncreaseHitPointsSkillStrategy());

		case 3:
			return new Thief(new SurpriseAttackSkillStrategy());

		default:
			System.out.println("invalid choice, returning Thief");
			return new Thief(new SurpriseAttackSkillStrategy());
			
		}// end switch
		
	}// end chooseHero method

	
	/*-------------------------------------------------------------------
	generateMonster randomly selects a Monster and returns it.  It utilizes
	a polymorphic reference (Monster) to accomplish this task.
	---------------------------------------------------------------------*/
	
	public static Monster generateMonster() {
		int choice;

		choice = (int) (Math.random() * 3) + 1;

		switch (choice) {
		case 1:
			return new Ogre();

		case 2:
			return new Gremlin();

		case 3:
			return new Skeleton();

		default:
			System.out.println("invalid choice, returning Skeleton");
			return new Skeleton();
			
		}// end switch
		
	}// end generateMonster method
	
} // end of class 