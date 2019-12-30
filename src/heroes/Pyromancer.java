package heroes;

import common.Visitor;
import heroes.abilities.AbilityFactory;
import heroes.abilities.AbilityType;
import heroes.strategies.PyromancerHighHP;

import java.io.IOException;
import java.util.ArrayList;

public class Pyromancer extends Hero {

    Pyromancer(final int hp, final int hpLvl, final HeroType type,
               final ArrayList<AbilityType> ab) {
        super(hp, hpLvl, type, ab);
        strategy = new PyromancerHighHP();
    }

    @Override
    public final int acceptAttack(final Hero attacker) {
        float damageAbility1 = AbilityFactory.getAbilityByType(attacker.abilities.get(0)).
                useAbility(attacker, this);
        float damageAbility2 = AbilityFactory.getAbilityByType(attacker.abilities.get(1)).
                useAbility(attacker, this);
        return Math.round(damageAbility1) + Math.round(damageAbility2);
    }



    @Override
    public final String toString() {
        return (isDead())
                ? "P dead"
                : "P " + getLvl() + " " + getXp() + " " + getHp() + " " + getCoordinates();
    }

    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}
