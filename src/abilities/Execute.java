package abilities;

import heros.HeroType;

import java.util.Map;

public class Execute extends Ability {
    int percent;
    int percentAddPerLevel;
    int maxPercent;

    public Execute(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier, int percent,
                   int percentAddPerLevel, int maxPercent) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.percent = percent;
        this.percentAddPerLevel = percentAddPerLevel;
        this.maxPercent = maxPercent;
    }
}
