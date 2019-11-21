package abilities;

import heros.HeroType;

import java.util.Map;

public class Fireblast extends Ability {
    public Fireblast(int dmg, float landAmplifier, int dmgAddPerLevel,
                     Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
    }
}
