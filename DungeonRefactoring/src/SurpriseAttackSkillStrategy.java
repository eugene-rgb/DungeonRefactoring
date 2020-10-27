
public class SurpriseAttackSkillStrategy implements SkillStrategy {

	/*
	 * The implementation below (useSkill) is pulled straight from the Thief class
	 * and put into this concrete "algorithm" that allows for easier maintainability
	 * and flexibility.
	 * 
	 * The strategyName class-level variable is used when attack options are
	 * displayed from battleChoices() (inside the Hero class).
	 * 
	 * Note: not everything is optimized for increased security and project
	 * organization. For example, the implementation below isn't using getters and setters
	 * to adjust the number of turns.
	 * 
	 */

	private final static String strategyName = "Surprise Attack";

	@Override
	public void useSkill(final Hero hero, DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + hero.getName() + " gets an additional turn.");
			hero.numTurns++;
			hero.attack(opponent);
		} // end surprise
		else if (surprise >= .8) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" + " blocked your attack!\n");
		} else
			hero.attack(opponent);
	}

	@Override
	public String getSkillName() {
		return this.strategyName;
	}

}
