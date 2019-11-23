package abilities;

import heros.Hero;
import heros.HeroType;

import java.util.Map;

public class Ignite extends Ability {
    private int dmgPerRound;
    private int DmgPerRoundAddLvl;

    public Ignite(int dmg, float landAmplifier, int dmgAddPerLevel,
                  Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.dmgPerRound = 50;
        DmgPerRoundAddLvl = 30;
    }

    @Override
    public int applyAbility(Hero opponent, int lvl) {
        return 0;
    }
}
