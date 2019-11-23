package abilities;

import heros.Hero;
import heros.HeroType;
import heros.Wizard;

import java.util.Map;

public abstract class Ability {
    int dmg;
    float landAmplifier;
    private int dmgAddPerLevel;
    Map<HeroType, Float> raceAmplifier;

    public Ability(int dmg, float landAmplifier, int dmgAddPerLevel,
                        Map<HeroType, Float> raceAmplifier) {
        this.dmg = dmg;
        this.landAmplifier = landAmplifier;
        this.dmgAddPerLevel = dmgAddPerLevel;
        this.raceAmplifier = raceAmplifier;
    }

    public abstract int applyAbility(Hero opponent, int lvl);

}
