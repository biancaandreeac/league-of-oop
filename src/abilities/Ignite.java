package abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public class Ignite extends Ability {
    private int dmgPerRound;
    private int dmgPerRoundAddLvl;

    public Ignite(int dmg, float landAmplifier, int dmgAddPerLevel,
                  Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
        this.dmgPerRound = 50;
        dmgPerRoundAddLvl = 30;
        preferredLand = CellType.Volcanic;
    }

    @Override
    public int applyAbility(Hero pyromancer, Hero opponent) {
        float damage = baseDamage(pyromancer);
        damage *= raceAmplifier.get(opponent.getType());
        damage = Math.round(damage);
        float periodicDamage = dmgPerRound + pyromancer.getLvl() * dmgPerRoundAddLvl;
        periodicDamage *= raceAmplifier.get(opponent.getType());
        opponent.delayDamage(Math.round(periodicDamage), 2);
        return (int) damage;
    }
}
