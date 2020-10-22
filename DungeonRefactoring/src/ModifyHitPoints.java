
public abstract class ModifyHitPoints {
	
	protected DungeonCharacter character;
	
	public void addHitPoints(int hitPoints) {
		////removed if statement checking for negative hit points, that would already be checked for by the isAlive method in DungeonCharacter (Collin)
		character.hitPoints += hitPoints;
		displayHitPoints(); ////added this call to show new total for hit points (Collin)

	}// end addHitPoints method
	
	public void subtractHitPoints(int hitPoints) {
		////removed unnecessary check to see if hit points are negative, this is handled by isAlive method in DungeonCharacter (Collin)
		character.hitPoints -= hitPoints;
		if (character.hitPoints < 0) character.hitPoints = 0;
		System.out.println(character.getName() + " got hit " + " for <" + hitPoints + "> points damage.");
		System.out.println(character.getName() + " now has " + getHitPoints() + " hit points remaining.");
		System.out.println();
			
		if (character.hitPoints == 0)
			System.out.println(character.name + " has been killed :-(");

	}// end method
	
	////added this method to handle displaying character's current hit point total (Collin)
	public void displayHitPoints() {
		System.out.println(character.hitPoints);
	}
	
	////moved this method from DungeonCharacter class as it is only needed by the hit point methods (Collin)
	public int getHitPoints() {
		return character.hitPoints;
	}// end getHitPoints
}
