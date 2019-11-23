package abilities;

import heros.Hero;
import heros.HeroType;

import java.util.Map;

public class Backstab extends Ability {
    int hits = 0;  // the number of hits. when it is 3 there is a bonus if you are in woods cell

    public Backstab(int dmg, float landAmplifier, int dmgAddPerLevel,
                    Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
    }

    @Override
    public int applyAbility(Hero opponent, int lvl) {
        return 0;
    }
}
