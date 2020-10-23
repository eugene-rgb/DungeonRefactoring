
public abstract class CharFactProducer {
	
	public static DungeonCharacter newCharacter(String type, int choice) {
		DungeonCharacter character;		
		
		if(type == "hero") {//send it a hero factory		
			//send choice to hero factory
			CharacterFactory spawnHero = new HeroFactory();
			character = spawnHero.generateCharacter(choice);
			return character;
		}else {//this is for the monster initalization
			//get random number then call monster factory
			int randomInt =  (int) (Math.random() * 3) + 1;///get random number generator
			CharacterFactory spawnMonster = new MonsterFactory();
			character = spawnMonster.generateCharacter(randomInt);			
			//have it use a monster factory
			return character;
		}		
	
	}
	
	
	
	
	
}
