
public class HeroFactory extends CharacterFactory {
	//Here is the hero factory it takes the input from the user to ouput the correct hero class that they choose(Dustin)
	
	
	protected DungeonCharacter generateCharacter(int choice) {
		DungeonCharacter hero;
		//Initialize heros
		//if they chose anything besides our choices they get informed that they will get the thief hero(Dustin)
		
		switch (choice) {		
		case 1:
			hero = new Warrior(new CrushingBlowSkillStrategy());
			return hero;
			
		case 2:					
			hero = new Sorceress(new IncreaseHitPointsSkillStrategy());
			return hero;
			
			/*The thief is the default so I removed one option from the original switch that had a duplicate of the thief being under default
			as long as thief remains the default hero this will not need to be changed(Dustin)*/
		default:
			//if they chose anything besides our choices they get informed that they will get the thief hero(Dustin)
			if(choice !=3){System.out.println("invalid choice, returning Thief");}
			hero = new Thief(new SurpriseAttackSkillStrategy());	
			return hero;
		}
	}	

}
/*
*This could be further expanded with our new skills classes to allow for specific factories per class and within that class factory pick specific skills
*
*/