package heroes;

import common.Visitor;
import heroes.abilities.AbilityFactory;
import heroes.abilities.AbilityType;
import heroes.strategies.WizardHighHP;
import heroes.strategies.WizardLowHP;

import java.io.IOException;
import java.util.ArrayList;

public class Wizard extends Hero {
    Wizard(final int hp, final int hpLvl, final HeroType type, final ArrayList<AbilityType> ab) {
        super(hp, hpLvl, type, ab);
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
    public void chooseStrategy() {
        int maxHp = getHpMax() + getLvl() * getHPlvl();
        if (maxHp / 4f < getHp() && getHp() < maxHp / 2f) {
            strategy = new WizardHighHP();
            strategy.applyStrategy(this);
        } else if (getHp() < maxHp / 4f) {
            strategy = new WizardLowHP();
            strategy.applyStrategy(this);
        }
    }

    @Override
    public final String toString() {
        return (isDead())
                ? "W dead"
                : "W " + getLvl() + " " + getXp() + " " + getHp() + " " + getCoordinates();
    }

    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}
