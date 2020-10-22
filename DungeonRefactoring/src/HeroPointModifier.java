
public class HeroPointModifier extends ModifyHitPoints{

	private final Hero character;
	
	public HeroPointModifier(Hero character) {
		this.character = character;
		super.character = character;
	}
	
	@Override
	////moved this method from the Hero class (Collin)
	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(character.name + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}// end method
	
	////moved this method from the Hero class as is only used by hero's subtractHitPoints method (Collin)
	public boolean defend() {
		return Math.random() <= character.getChanceToBlock();
	}

}
