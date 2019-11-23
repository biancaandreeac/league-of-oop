package heros;

import abilities.Ability;
import abilities.AbilityFactory;
import abilities.AbilityType;

import java.util.ArrayList;

public class Pyromancer extends Hero {
    Pyromancer(int HP, int HP_lvl, HeroType type, ArrayList<AbilityType> ab) {
        super(HP, HP_lvl, type, ab);
    }

    int acceptAttack(Hero hero) {
        return hero.attack(this);
    }

    @Override
    protected int attack(Rogue rogue) {
        System.out.println("Pyromancer attacks rogue");

        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, rogue);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, rogue);

        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Knight knight) {
        System.out.println("Pyromancer attacks knight");
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, knight);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, knight);

        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Wizard wizard) {
        System.out.println("Pyromancer attacks wizard");

        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, wizard);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, wizard);

        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        System.out.println("Pyromancer attacks pyromancer");
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, pyromancer);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, pyromancer);

        return damage1 + damage2;
    }

    @Override
    public void print() {
        if (isDead()) {
            System.out.println("P dead");
        } else {
            System.out.println("P " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y);
        }
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "P dead";
        } else {
            return "P " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y;
        }
    }
}
