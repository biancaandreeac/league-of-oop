package heros;

import abilities.Ability;
import abilities.AbilityType;
import map.Cell;
import map.Map;

import java.util.ArrayList;

public class Hero {
    private int HP, HP_lvl;
    private int XP = 0;
    private int lvl = 1;
    private HeroType type;
    private Cell location;
    private ArrayList<AbilityType> abilities;

    Hero(final int HP, final int HP_lvl, final HeroType type, final ArrayList<AbilityType> ab) {
        this.HP = HP;
        this.type = type;
        abilities = ab;
    }

    public void changeLocation(int x, int y) {
        location = Map.getCellAt(x, y);
    }
}
