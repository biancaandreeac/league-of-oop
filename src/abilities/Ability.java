package abilities;

import heros.HeroType;

import java.util.Map;

public class Ability {
    int dmg;
    float landAmplifier;
    int dmgAddPerLevel;
    Map<HeroType, Float> raceAmplifier;

    public Ability(int dmg, float landAmplifier, int dmgAddPerLevel,
                        Map<HeroType, Float> raceAmplifier) {
        this.dmg = dmg;
        this.landAmplifier = landAmplifier;
        this.dmgAddPerLevel = dmgAddPerLevel;
        this.raceAmplifier = raceAmplifier;
    }

}
