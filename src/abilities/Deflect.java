package abilities;

import heros.HeroType;

import java.util.Map;

public class Deflect extends Ability {
    int maxPercent;
    // dmg from here is actually percent. same goes for dmgadd...
    public Deflect(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier, int maxPercent) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.maxPercent = maxPercent;
    }
}
