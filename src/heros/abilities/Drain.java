package heros.abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Drain extends Ability {
    private float percent;
    private float percentPerLvl;

    // dmg from here is actually percent. same goes for dmgadd...
    Drain(final int dmg, final float landAmplifier, final int dmgAddPerLevel,
          final Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        percent = dmg / 100f;
        percentPerLvl = dmgAddPerLevel / 100f;
        preferredLand = CellType.Desert;
    }

    @Override
    public int applyAbility(final Hero wizard, final Hero opponent) {
        int baseHP, damage;
        float amplifier;

        baseHP = Math.min(Math.round(0.3f * opponent.getMAX_HP()), opponent.getHP());
        amplifier = percent + percentPerLvl * wizard.getLvl();
        amplifier *= raceAmplifier.get(opponent.getType());

        if (opponent.getLocationType() == preferredLand) {
            amplifier *= landAmplifier;
        }

        damage = Math.round(amplifier * baseHP);

        return damage;
    }
}
