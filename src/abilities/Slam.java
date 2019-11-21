package abilities;

import heros.HeroType;

import java.util.Map;

public class Slam extends Ability {
    boolean incapacity; ///////////////////

    public Slam(int dmg, float landAmplifier, int dmgAddPerLevel, Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
    }
}
