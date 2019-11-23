package abilities;

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
    public int applyAbility(Hero wizard, Hero opponent) {
        // pls think!
        Ability ability;
        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(0));
        float damage1 = ability.baseDamage(opponent);
        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(1));
        float damage2 = ability.baseDamage(opponent);

        float damage = Math.round(damage1) + Math.round(damage2);

        float limit = percent + wizard.getLvl() * percentPerLvl;
        limit = Math.min(limit, maxPercent);

        limit *= raceAmplifier.get(opponent.getType());

        if (opponent.getLocationType() == CellType.Desert) {
            limit *= landAmplifier;
        }

        return Math.round(damage * limit);
    }
}
