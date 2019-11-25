package heros;

import heros.abilities.Ability;
import heros.abilities.AbilityFactory;
import heros.abilities.AbilityType;

import java.util.ArrayList;

public class Rogue extends Hero{
    public int backstabHits = 0;

    Rogue(int HP, int HP_lvl, HeroType type, ArrayList<AbilityType> ab) {
        super(HP, HP_lvl, type, ab);
    }

    int acceptAttack(Hero hero) {
        return hero.attack(this);
    }

    @Override
    protected int attack(Rogue rogue) {
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, rogue);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, rogue);
        backstabHits++;

        return damage1 + damage2;
    }

    @Override
    protected int attack(Knight knight) {
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, knight);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, knight);

        backstabHits++;
        return damage1 + damage2;
    }

    @Override
    protected int attack(Wizard wizard) {
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, wizard);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, wizard);

        backstabHits++;
        return damage1 + damage2;
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, pyromancer);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, pyromancer);

        backstabHits++;
        return damage1 + damage2;
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "R dead";
        } else {
            return "R " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y;
        }
    }
}
