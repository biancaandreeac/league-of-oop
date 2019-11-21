package abilities;

import heros.HeroType;

import java.util.Map;

public class Ignite extends Ability {
    int dmgPerRound;
    int DmgPerRoundAddLvl;

    public Ignite(int dmg, float landAmplifier, int dmgAddPerLevel,
                  Map<HeroType, Float> raceAmplifier, int dmgPerRound,
                  int dmgPerRoundAddLvl) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.dmgPerRound = dmgPerRound;
        DmgPerRoundAddLvl = dmgPerRoundAddLvl;
    }
}
