
public class IncreaseHitPointsSkillStrategy implements SkillStrategy {

	/*
	 * The implementation below (useSkill) is pulled straight from the Sorceress
	 * class and put into this concrete "algorithm" that allows for easier
	 * maintainability and flexibility.
	 * 
	 * The strategyName class-level variable is used when attack options are
	 * displayed from battleChoices() (inside the Hero class).
	 * 
	 * Heroes that have the ability to heal should implement a Healable interface to
	 * allow for greater flexibility within this class. Right now only one hero has
	 * the ability to heal, so it's not programmed to an interface.
	 */

	private final static String strategyName = "Increase hitpoints";

	@Override
	public void useSkill(final Hero hero, final DungeonCharacter opponent) {
		if (hero instanceof Sorceress) {
			Sorceress sorceress = (Sorceress) hero;

			int hPoints;

			hPoints = (int) (Math.random() * (sorceress.getMAX_HEAL() - sorceress.getMIN_HEAL() + 1))
					+ sorceress.getMIN_HEAL();

			hero.hpModifier.addHitPoints(hPoints);
			System.out.println(hero.getName() + " added [" + hPoints + "] points.\n"
					+ "Total hit points remaining are: " + hero.hpModifier.getHitPoints());
			System.out.println();

		} else {
			System.out.println("Hero isn't allowed to heal--need min/max values");
		}
	}

	@Override
	public String getSkillName() {
		return this.strategyName;
	}

}
