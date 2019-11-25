package heros;

import heros.abilities.AbilityType;
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

    private int delayedDamage;
    private int noDelayedRounds = 0;

    private HeroType type;
    private Cell location;
    ArrayList<AbilityType> abilities;

    Hero(final int HP, final int HP_lvl, final HeroType type, final ArrayList<AbilityType> ab) {
        this.HP = HP;
        MAX_HP = HP;
        this.HP_lvl = HP_lvl;
        this.type = type;
        abilities = ab;
        XP = lvl = 0;
        incapacity = 0;
    }

    int getXP() {
        return XP;
    }

    public int getHP() {
        return HP;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHPlvl() {
        return HP_lvl;
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

    public ArrayList<AbilityType> getAbilities() {
        return abilities;
    }

    public boolean canMove() {
        if (incapacity == 0) {
            return true;
        }
        --incapacity;
        return false;
    }

    public boolean isDead() {
        if (HP < 0) HP = 0;
        if (HP == 0) {
            location.leave(this);
        }
        return HP == 0;
    }

    private void checkLvl() {
        if (!isDead()) {
            int res = 250 + lvl * 50;
            while (res <= XP) {
                lvl++;
                res += 50;
                HP = MAX_HP + lvl * HP_lvl;
            }
        }
    }

    private void subHP(int delta) {
        HP -= delta;
    }

    private void addXP(int delta) {
        XP += delta;
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

            int damage1, damage2;
            if (type == HeroType.Wizard) {
                damage1 = opponent.acceptAttack(this);
                damage2 = this.acceptAttack(opponent);
            } else {
                damage2 = this.acceptAttack(opponent);
                damage1 = opponent.acceptAttack(this);
            }

            opponent.subHP(damage1);
            subHP(damage2);

            if (opponent.getHP() <= 0) {
                addXP(Math.max(0, 200 - (getLvl() - opponent.getLvl()) * 40));
            }

            if (getHP() <= 0) {
                opponent.addXP(Math.max(0, 200 - (opponent.getLvl() - getLvl()) * 40));
            }

            checkLvl();
            opponent.checkLvl();
            opponent.location.leave(opponent);
        }

        location.leave(this);
    }

    public void DoT() {
        if (noDelayedRounds != 0) {
            subHP(delayedDamage);
            --noDelayedRounds;
        } else {
            delayedDamage = 0;
        }
    }

    public void damageOvertime(int dmg, int rounds, int incapacity) {
        delayedDamage = dmg;
        noDelayedRounds = rounds;
        this.incapacity = incapacity;
    }

    abstract int acceptAttack(Hero hero);
    protected abstract int attack(Rogue rogue);
    protected abstract int attack(Knight knight);
    protected abstract int attack(Wizard wizard);
    protected abstract int attack(Pyromancer pyromancer);
}
