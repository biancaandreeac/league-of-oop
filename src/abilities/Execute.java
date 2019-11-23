package abilities;

import heros.Hero;
import heros.HeroType;

import java.util.Map;

public class Execute extends Ability {
    private int percent;
    private int percentAddPerLevel;
    private int maxPercent;

    public Execute(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.percent = 20;
        this.percentAddPerLevel = 1;
        this.maxPercent = 40;
    }

    @Override
    public int applyAbility(Hero opponent, int lvl) {
        return 0;
    }
}
