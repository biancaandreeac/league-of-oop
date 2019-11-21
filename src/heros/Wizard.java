package heros;

import abilities.AbilityType;

import java.util.ArrayList;

public class Wizard extends Hero {
    Wizard(int HP, int HP_lvl, HeroType type, ArrayList<AbilityType> ab) {
        super(HP, HP_lvl, type, ab);
    }
}
