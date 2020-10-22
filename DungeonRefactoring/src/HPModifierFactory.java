
public abstract class HPModifierFactory {

	////added this factory to choose between the hit point modifiers depending on which character type is being instantiated
	////this allows for future expansion of the methods in which hit points are handled by different characters (Collin)
	protected static ModifyHitPoints getHPModifier(DungeonCharacter character) {
		if(character instanceof Hero) {
			return new HeroPointModifier((Hero)character);
		}else if(character instanceof Monster) {
			return new MonsterPointModifier((Monster)character);
		}else {
			return null;
		}
	}
}
