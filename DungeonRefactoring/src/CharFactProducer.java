
public abstract class CharFactProducer {
	
	public static DungeonCharacter newCharacter(String type) {
		DungeonCharacter character;	
		
		if(type == "hero") {//send it a hero factory		
			
			//send choice to hero factory
			System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
			int choice = Keyboard.readInt();
			CharacterFactory spawnHero = new HeroFactory();
			character = (Hero) spawnHero.generateCharacter(choice);
			
			return character;
		}else {//this is for the monster initalization
			
			//the random int makes it so what ever monster chosen will be a random monster. If there are more monsters in the future only the range will need to be changed(Dustin)
			int randomInt =  (int) (Math.random() * 3) + 1;
			CharacterFactory spawnMonster = new MonsterFactory();
			character = (Monster) spawnMonster.generateCharacter(randomInt);			
			//have it use a monster factory
			return character;
		}		
	
	}
	
	
	
	
	
}
