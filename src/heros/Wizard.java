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

        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, rogue);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, rogue);

        System.out.println("WR Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Knight knight) {
        System.out.println("Wizard attacks knight");
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, knight);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, knight);

        System.out.println("WK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Wizard wizard) {
        System.out.println("Wizard attacks wizard");
        Ability ability = AbilityFactory.getAbilityByType(abilities.get(0));
        return ability.applyAbility(this, wizard);
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        System.out.println("Wizard attacks pyromancer");

        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, pyromancer);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, pyromancer);

        System.out.println("WP Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    public void print() {
        if (isDead()) {
            System.out.println("W dead");
        } else {
            System.out.println("W " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y);
        }
    }

    @Override
    public String toString() {
        return (isDead())
                ? "W dead"
                : "W " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y;
    }
}
