package abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Fireblast extends Ability {
    public Fireblast(int dmg, float landAmplifier, int dmgAddPerLevel,
                     Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        preferredLand =  CellType.Volcanic;
    }

    @Override
    public int applyAbility(Hero pyromancer, Hero opponent) {
        float damage = baseDamage(pyromancer);
        damage *= raceAmplifier.get(opponent.getType());
        damage = Math.round(damage);
        return (int) damage;
    }
}
