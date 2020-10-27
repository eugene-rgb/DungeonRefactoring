
/*
 * This is the main interface implemented by all concrete special skill Strategies/"Algorithms": 
 * it is the key interface for the refactoring of special skills using the Strategy Pattern. 
 */

public interface SkillStrategy {
	public void useSkill(final Hero hero, final DungeonCharacter character);

	public String getSkillName();
}
