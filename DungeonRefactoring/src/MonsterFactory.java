
public class MonsterFactory extends CharacterFactory {

	
	protected DungeonCharacter generateCharacter(int choice) {
		DungeonCharacter monster;
		//returns monster based on choice passed into it(Dustin)
		switch (choice) {		
		case 1:
			monster = new Ogre();
			return monster;
			
		case 2:					
			monster = new Gremlin();
			return monster;
			
		default:
			monster = new Skeleton();
			return monster;	
		}
	}

}
