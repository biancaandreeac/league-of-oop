package heros.abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Deflect extends Ability {
    private float percent;
    private float maxPercent;
    private float percentPerLvl;

    // dmg from here is actually percent. same goes for dmgadd...
    public Deflect(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.maxPercent = 70;
        percent = dmg;
        percent /= 100;
        percentPerLvl = dmgAddPerLevel;
        percentPerLvl /= 100;
        preferredLand = CellType.Desert;
    }

    @Override
    public int applyAbility(final Hero wizard, final Hero opponent) {
        // POATE SE POATE MAI BINE
        Ability ability;
        float damage, amplifier;

        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(0));
        damage = ability.baseDamage(opponent);
        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(1));
        damage += ability.baseDamage(opponent);

        amplifier = Math.min(maxPercent, percent + wizard.getLvl() * percentPerLvl);
        amplifier *= raceAmplifier.get(opponent.getType());

        if (opponent.getLocationType() == preferredLand) {
            amplifier *= landAmplifier;
        }

        return Math.round(damage * amplifier);
    }
}
