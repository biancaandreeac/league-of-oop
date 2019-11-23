package heros;

import abilities.Ability;
import abilities.AbilityType;
import map.Cell;
import map.CellType;
import map.Map;

import java.util.ArrayList;

public abstract class Hero {
    private int HP, HP_lvl;
    private final int MAX_HP;
    private int XP;
    private int lvl;
    private int incapacity;
    int x, y; // coordinates

    private HeroType type;
    private Cell location;
    ArrayList<AbilityType> abilities;

    Hero(final int HP, final int HP_lvl, final HeroType type, final ArrayList<AbilityType> ab) {
        this.HP = HP;
        MAX_HP = HP;
        this.type = type;
        abilities = ab;
        XP = lvl = 0;
        incapacity = 0;
    }

    public int getXP() {
        return XP;
    }

    public int getHP() {
        return HP;
    }

    public int getLvl() {
        return lvl;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public HeroType getType() {
        return type;
    }

    public CellType getLocationType() {
        return location.getType();
    }

    public void subHP(int delta) {
        HP -= delta;
    }

    public void addXP(int delta) {
        XP += delta;
    }

    public boolean isDead() {
        return HP == 0;
    }

    public boolean canMove() {
        if (incapacity == 0) {
            return true;
        }
        --incapacity;
        return false;
    }

    public void initLocation(int x, int y) {
        this.x = x;
        this.y = y;
        location = Map.getCellAt(x, y);
        location.visit(this);
    }

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
        location.leave(this);
        location = Map.getCellAt(x, y);
        location.visit(this);
    }



    public void fight() {
        Hero opponent = location.getOpponent(this);
        if (opponent != null) {

            int damage1 = opponent.acceptAttack(this);
            int damage2 = this.acceptAttack(opponent);

            if (damage1 > opponent.getHP()) {
                opponent.subHP(opponent.getHP());
                addXP(Math.max(0, 200 - (getLvl() - opponent.getLvl()) * 40));
            } else {
                opponent.subHP(damage1);
            }

            if (damage2 > opponent.getHP()) {
                subHP(opponent.getHP());
                opponent.addXP(Math.max(0, 200 - (opponent.getLvl() - getLvl()) * 40));
            } else {
                subHP(damage2);
            }

            location.leave(this);
            opponent.location.leave(opponent);
        }
    }

    public void checkLvl() {
        int res = 250 + lvl * 50;
        while (res <= lvl) {
            lvl++;
            res = 250 + lvl * 50;
        }
    }


    abstract int acceptAttack(Hero hero);
    protected abstract int attack(Rogue rogue);
    protected abstract int attack(Knight knight);
    protected abstract int attack(Wizard wizard);
    protected abstract int attack(Pyromancer pyromancer);


    public abstract void print();
}
