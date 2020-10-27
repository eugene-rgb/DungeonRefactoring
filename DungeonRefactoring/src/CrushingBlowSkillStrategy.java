
public class CrushingBlowSkillStrategy implements SkillStrategy {

	/*
	 * The implementation below (useSkill) is pulled straight from the Warrior class
	 * and put into this concrete "algorithm" that allows for easier maintainability
	 * and flexibility. 
	 * 
	 * The strategyName class-level variable is used when attack
	 * options are displayed from battleChoices() (inside the Hero class).
	 * 
	 */

	private final static String strategyName = "Crushing Blow on Opponent";

	@Override
	public void useSkill(final Hero hero, final DungeonCharacter opponent) {
		if (Math.random() <= .4) {
			int blowPoints = (int) (Math.random() * 101) + 75;
			System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.hpModifier.subtractHitPoints(blowPoints);
		} // end blow succeeded
		else {
			System.out.println(hero.getName() + " failed to land a crushing blow");
			System.out.println();
		} // blow failed

	}

	@Override
	public String getSkillName() {
		return this.strategyName;
	}

}
