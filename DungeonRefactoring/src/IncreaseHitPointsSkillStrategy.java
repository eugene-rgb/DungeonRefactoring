
public class IncreaseHitPointsSkillStrategy implements SkillStrategy {

	private final static String strategyName = "Increase hitpoints";

	@Override
	public void useSkill(final Hero hero, final DungeonCharacter opponent) {
		if (hero instanceof Sorceress) {
			Sorceress sorceress = (Sorceress) hero;

			int hPoints;

			hPoints = (int) (Math.random() * (sorceress.getMAX_ADD() - sorceress.getMIN_ADD() + 1))
					+ sorceress.getMIN_ADD();
			
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
