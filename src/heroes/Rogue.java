package heroes;

import common.Visitor;
import heroes.abilities.AbilityFactory;
import heroes.abilities.AbilityType;

import java.io.IOException;
import java.util.ArrayList;

public class Rogue extends Hero {
    private int backstabHits = 0;
    private final int maxHits = 3;

    Rogue(final int hp, final int hpLvl, final HeroType type, final ArrayList<AbilityType> ab) {
        super(hp, hpLvl, type, ab);
    }

    public final int getHits() {
        if (backstabHits == maxHits) {
            backstabHits = 0;
        }
        return backstabHits;
    }

    public final void incHits() {
        backstabHits++;
    }

    public final void resetBackstabHits() {
        backstabHits -= maxHits;
    }

    @Override
    public final int acceptAttack(final Hero attacker) {
        float damage1 = AbilityFactory.getAbilityByType(attacker.abilities.get(0)).
                useAbility(attacker, this);
        float damage2 = AbilityFactory.getAbilityByType(attacker.abilities.get(1)).
                useAbility(attacker, this);
        return Math.round(damage1) + Math.round(damage2);
    }



    @Override
    public final String toString() {
        return (isDead())
                ? "R dead"
                : "R " + getLvl() + " " + getXp() + " " + getHp() + " " + getCoordinates();
    }

    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}
