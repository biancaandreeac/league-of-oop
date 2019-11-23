package abilities;

import heros.Hero;
import heros.HeroType;

import java.util.Map;

public class Deflect extends Ability {
    private int percent;
    private int maxPercent;
    private int percentPerLvl;

    // dmg from here is actually percent. same goes for dmgadd...
    public Deflect(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.maxPercent = 70;
        percent = dmg;
        percentPerLvl = dmgAddPerLevel;
    }

    @Override
    public int applyAbility(Hero opponent, int lvl) {
        return 0;
    }
}
