
public class MonsterPointModifier extends ModifyHitPoints{

	private final Monster character;
	
	public MonsterPointModifier(Monster character) {
		this.character = character;
		super.character = character;
	}
	
	@Override
	////moved this method from Monster class (Collin)
	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		heal();

	}// end method
	
	////moved from Monster class as it is only used by the monster's subtractHitPoints method (Collin)
	public void heal() {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= character.getChanceToHeal() && (character.hitPoints > 0));

		if (canHeal) {
			healPoints = (int) (Math.random() * (character.maxHeal - character.minHeal + 1)) + character.minHeal;
			addHitPoints(healPoints);
			System.out.println(character.name + " healed itself for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + character.hitPoints);
			System.out.println();
		} // end can heal

	}// end heal method
}
