
public class HeroFactory extends CharacterFactory {
	
	protected DungeonCharacter generateCharacter(int choice) {
		DungeonCharacter hero;
		//Initialize heros
		switch (choice) {		
		case 1:
			hero = new Warrior(new CrushingBlowSkillStrategy());
			return hero;
			
		case 2:					
			hero = new Sorceress(new IncreaseHitPointsSkillStrategy());
			return hero;
			
		default:
			hero = new Thief(new SurpriseAttackSkillStrategy());	
			return hero;
		}
	}	

}
/*
*This could be further expanded with our new skills classes to allow for specific factories per class and within that class factory pick specific skills
*
*/