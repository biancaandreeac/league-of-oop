package abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Drain extends Ability {
    private float percent;
    private float percentPerLvl;

    // dmg from here is actually percent. same goes for dmgadd...
    Drain(int dmg, float landAmplifier, int dmgAddPerLevel,
          Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        percent = dmg;
        percent /= 100;
        percentPerLvl = dmgAddPerLevel;
        percentPerLvl /= 100;
    }

    @Override
    public int applyAbility(Hero opponent, int lvl) {
        int baseHP, damage;
        float percent;

        baseHP = Math.min(Math.round(0.3f * opponent.getMAX_HP()), opponent.getHP());
        percent = this.percent + percentPerLvl * lvl;
        percent *= raceAmplifier.get(opponent.getType());

        if (opponent.getLocationType() == CellType.Desert) {
            percent *= landAmplifier;
        }

        damage = Math.round(percent * baseHP);

        return damage;
    }
}
