package abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Paralysis extends Ability {

    public Paralysis(int dmg, float landAmplifier, int dmgAddPerLevel, Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        preferredLand = CellType.Woods;
    }

    @Override
    public int applyAbility(Hero rogue, Hero opponent) {
        float damage = baseDamage(rogue);

        damage *= raceAmplifier.get(opponent.getType());
        damage = Math.round(damage);

        if (opponent.getLocationType() == CellType.Woods) {
            opponent.delayDamage((int) damage, 6);
        } else {
            opponent.delayDamage((int )damage, 3);
        }

        return (int) damage;
    }
}
