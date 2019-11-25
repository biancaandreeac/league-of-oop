package heros.abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Slam extends Ability {

    public Slam(int dmg, float landAmplifier, int dmgAddPerLevel, Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        preferredLand = CellType.Land;
    }

    @Override
    public int applyAbility(Hero knight, Hero opponent) {
        float damage = baseDamage(knight);
        damage *= raceAmplifier.get(opponent.getType());
        damage = Math.round(damage);
//        opponent.setIncapacity(1);
        opponent.damageOvertime(0, 0, 1);
        return (int) damage;
    }
}
