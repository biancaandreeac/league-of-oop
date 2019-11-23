package heros;

import abilities.Ability;
import abilities.AbilityFactory;
import abilities.AbilityType;

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
        System.out.println("Rogue attacks rogue");
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
        System.out.println("Rogue attacks knight");
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, knight);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, knight);

        backstabHits++;
        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Wizard wizard) {
        System.out.println("Rogue attacks wizard");
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, wizard);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, wizard);

        backstabHits++;
        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        System.out.println("Rogue attacks pyromancer");
        if (backstabHits == 3) backstabHits = 0;
        Ability ability;
        ability = AbilityFactory.getAbilityByType(abilities.get(0));
        int damage1 = ability.applyAbility(this, pyromancer);
        ability = AbilityFactory.getAbilityByType(abilities.get(1));
        int damage2 = ability.applyAbility(this, pyromancer);

        backstabHits++;
        System.out.println("KK Damages" + damage1 + " " + damage2);
        return damage1 + damage2;
    }

    @Override
    public void print() {
        if (isDead()) {
            System.out.println("R dead");
        } else {
            System.out.println("R " + getLvl() + " " + getXP() + " " + getHP() + " " + x + " " + y);
        }
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
