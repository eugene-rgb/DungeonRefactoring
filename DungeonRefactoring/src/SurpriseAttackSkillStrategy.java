
public class SurpriseAttackSkillStrategy implements SkillStrategy {
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
