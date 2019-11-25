package heros.abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Execute extends Ability {
    private float percent;
    private float percentAddPerLevel;
    private float maxPercent;

    public Execute(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        percent = 0.2f;
        percentAddPerLevel = 0.01f;
        maxPercent = 0.4f;
        preferredLand = CellType.Land;
    }

    @Override
    public int applyAbility(final Hero knight, final Hero opponent) {
        float limit;
        limit = opponent.getMAX_HP() + opponent.getLvl() * opponent.getHPlvl();
        limit *= Math.min(percent + knight.getLvl() * percentAddPerLevel, maxPercent);
        limit = Math.round(limit);

        if (opponent.getHP() <= limit) {
            return opponent.getHP();
        } else {
            float damage = baseDamage(knight);
            damage *= raceAmplifier.get(opponent.getType());
            damage = Math.round(damage);
            return (int) damage;
        }
    }
}
