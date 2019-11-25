package heros.abilities;

import heros.Hero;
import heros.HeroType;
import map.CellType;

import java.util.Map;

public abstract class Ability {
    float landAmplifier;
    private int dmg;
    private int dmgAddPerLevel;
    CellType preferredLand;
    Map<HeroType, Float> raceAmplifier;

    public Ability(int dmg, float landAmplifier, int dmgAddPerLevel,
                   Map<HeroType, Float> raceAmplifier) {
        this.dmg = dmg;
        this.landAmplifier = landAmplifier;
        this.dmgAddPerLevel = dmgAddPerLevel;
        this.raceAmplifier = raceAmplifier;
    }

    int baseDamage(Hero attacker) {
        float damage;
        damage = dmg + attacker.getLvl() * dmgAddPerLevel;
        if (attacker.getLocationType() == preferredLand) {
            damage *= landAmplifier;
            damage = Math.round(damage);
        }
        return (int) damage;
    }

    public abstract int applyAbility(Hero attacker, Hero opponent);
}
