package abilities;

import heros.HeroType;

import java.util.Map;

public class Paralysis extends Ability {
    int extraRounds;

    public Paralysis(int dmg, float landAmplifier, int dmgAddPerLevel, Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
    }
}
