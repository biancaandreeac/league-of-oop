package heros.abilities;

import heros.Hero;
import heros.Rogue;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Backstab extends Ability {

    public Backstab(int dmg, float landAmplifier, int dmgAddPerLevel,
                    Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        preferredLand = CellType.Woods;
    }

    @Override
    int baseDamage(Hero rogue) {
        int damage = super.baseDamage(rogue);

        if (rogue.getLocationType() == CellType.Woods && ((Rogue) rogue).backstabHits >= 0) {
            damage *= 1.5f;
            damage = Math.round(damage);
        }

        return damage;
    }

    @Override
    public int applyAbility(Hero rogue, Hero opponent) {
        float damage = baseDamage(rogue);

        if (rogue.getLocationType() == CellType.Woods && ((Rogue) rogue).backstabHits >= 0) {
            ((Rogue) rogue).backstabHits -= 3;
        }

        damage *= raceAmplifier.get(opponent.getType());
        damage = Math.round(damage);

        return (int) damage;
    }
}
