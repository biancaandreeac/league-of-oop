package heros;

import abilities.Ability;
import abilities.AbilityFactory;
import abilities.AbilityType;

import java.util.ArrayList;

public class Wizard extends Hero {
    Wizard(int HP, int HP_lvl, HeroType type, ArrayList<AbilityType> ab) {
        super(HP, HP_lvl, type, ab);
    }

    int acceptAttack(Hero hero) {
        return hero.attack(this);
    }

    @Override
    protected int attack(Rogue rogue) {
        System.out.println("Wizard attacks rogue");
        return 0;
    }

    @Override
    protected int attack(Knight knight) {
        System.out.println("Wizard attacks knight");
        return 0;
    }

    @Override
    protected int attack(Wizard wizard) {
        System.out.println("Wizard attacks wizard");
        Ability ability = AbilityFactory.getAbilityByType(abilities.get(0));
        return ability.applyAbility(wizard, getLvl());
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        System.out.println("Wizard attacks pyromancer");
        return 0;
    }

    @Override
    public void print() {
        if (isDead()) System.out.println("W dead");
        System.out.println("W " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y);
    }

    @Override
    public String toString() {
        return (isDead())
                ? "W dead"
                : "W " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y;
    }
}
