package heros;

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
        return 0;
    }

    @Override
    protected int attack(Knight knight) {
        System.out.println("Pyromancer attacks knight");
        return 0;
    }

    @Override
    protected int attack(Wizard wizard) {
        System.out.println("Pyromancer attacks wizard");
        return 0;
    }

    @Override
    protected int attack(Pyromancer pyromancer) {
        System.out.println("Pyromancer attacks pyromancer");
        return 0;
    }

    @Override
    public void print() {

    }
}
