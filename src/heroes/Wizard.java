package heroes;

import heroes.abilities.AbilityFactory;
import heroes.abilities.AbilityType;

import java.util.ArrayList;

public class Wizard extends Hero {
    Wizard(final int hp, final int hpLvl, final HeroType type, final ArrayList<AbilityType> ab) {
        super(hp, hpLvl, type, ab);
    }

    @Override
    public final int acceptAttack(final Hero attacker) {
        int damageAbility1 = AbilityFactory.getAbilityByType(attacker.abilities.get(0)).
                useAbility(attacker, this);
        int damageAbility2 = AbilityFactory.getAbilityByType(attacker.abilities.get(1)).
                useAbility(attacker, this);
        return damageAbility1 + damageAbility2;
    }

    @Override
    public final String toString() {
        return (isDead())
                ? "W dead"
                : "W " + getLvl() + " " + getXp() + " " + getHp() + " " + getCoordinates();
    }
}
