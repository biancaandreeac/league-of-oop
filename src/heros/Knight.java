package heros;

import heros.abilities.Ability;
import heros.abilities.AbilityFactory;
import heros.abilities.AbilityType;

import java.util.ArrayList;

public class Knight extends Hero {
    Knight(int HP, int HP_lvl, HeroType type, ArrayList<AbilityType> ab) {
        super(HP, HP_lvl, type, ab);
    }

    int acceptAttack(Hero hero) {
        return hero.attack(this);
    }

    @Override
    protected int attack(Rogue rogue) {
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, rogue);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, rogue);

        return damage1 + damage2;
    }

    @Override
    protected int attack(Knight knight) {
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, knight);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, knight);

        return damage1 + damage2;
    }

    @Override
    protected int attack(Wizard wizard) {
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, wizard);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, wizard);

        return damage1 + damage2;
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, pyromancer);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, pyromancer);

        return damage1 + damage2;
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "K dead";
        } else {
            return "K " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y;
        }
    }
}
