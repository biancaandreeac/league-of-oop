package heroes;

import common.Constants;
import heroes.abilities.AbilityType;
import map.Cell;
import map.CellType;
import map.Map;

import java.util.ArrayList;

public abstract class Hero {
    private int hp, hpLvl;
    private final int hpMax;
    private int xp;
    private int lvl;
    private int incapacity;
    private int x, y; // coordinates

    private int overtimeDamage;
    private int overtimeRounds = 0;

    private HeroType type;
    private Cell location;
    protected ArrayList<AbilityType> abilities;

    Hero(final int hp, final int hpLvl, final HeroType type, final ArrayList<AbilityType> ab) {
        this.hp = hp;
        hpMax = hp;
        this.hpLvl = hpLvl;
        this.type = type;
        abilities = ab;
        xp = 0;
        lvl = 0;
        incapacity = 0;
    }

    final int getXp() {
        return xp;
    }

    public final int getHp() {
        return hp;
    }

    public final int getLvl() {
        return lvl;
    }

    public final int getHPlvl() {
        return hpLvl;
    }

    public final int getHpMax() {
        return hpMax;
    }

    public final CellType getLocationType() {
        return location.getType();
    }

    public final ArrayList<AbilityType> getAbilities() {
        return abilities;
    }

    public final boolean canMove() {
        if (incapacity == 0) {
            return true;
        }
        --incapacity;
        return false;
    }

    public final boolean isDead() {
        if (hp <= 0) {
            hp = 0;
            location.leave(this);
            return true;
        }
        return false;
    }

    private void checkLvl() {
        if (isDead()) {
            return;
        }
        final int baseXP = 250;
        final int lvlXP = 50;
        int res = baseXP + lvl * lvlXP;
        while (res <= xp) {
            lvl++;
            res += lvlXP;
            hp = hpMax + lvl * hpLvl;
        }
    }

    private void subHP(final int delta) {
        hp -= delta;
    }

    private void addXP(final int delta) {
        xp += delta;
    }

    public final void initLocation(final int newX, final int newY) {
        x = newX;
        y = newY;
    }

    public final void move(final int deltaX, final int deltaY) {
        x += deltaX;
        y += deltaY;
        location = Map.getCellAt(x, y);
        location.visit(this);
    }

    public final void fight() {
        Hero opponent = location.getOpponent(this);
        if (opponent != null) {
            int dmgOpponent, dmgThis;

            /* if there is a wizard fighting it has to be first, otherwise if it fight *
             * a rogue and it has already applied that amplifier the base damage will  *
             * not be computed correctly.                                              */
            if (type == HeroType.Wizard) {
                dmgOpponent = opponent.acceptAttack(this);
                dmgThis = this.acceptAttack(opponent);
            } else {
                dmgThis = this.acceptAttack(opponent);
                dmgOpponent = opponent.acceptAttack(this);
            }

            opponent.subHP(dmgOpponent);
            subHP(dmgThis);

            int computedXp;
            /* Add xp if someone is defeated */
            if (opponent.getHp() <= 0) {
                computedXp = Constants.XP_MAX;
                computedXp -= ((getLvl() - opponent.getLvl()) * Constants.XP_MULTIPLIER);
                addXP(Math.max(0, computedXp));
            }
            if (getHp() <= 0) {
                computedXp = Constants.XP_MAX;
                computedXp -= ((opponent.getLvl() - getLvl()) * Constants.XP_MULTIPLIER);
                opponent.addXP(Math.max(0, computedXp));
            }

            checkLvl();
            opponent.checkLvl();
            opponent.location.leave(opponent);
        }

        location.leave(this);
    }

    public final void applyDamageOvertime() {
        if (overtimeRounds != 0) {
            subHP(overtimeDamage);
            --overtimeRounds;
        } else {
            overtimeDamage = 0;
        }
    }

    public final void setDamageOverTime(final int dmg, final int rounds, final int immobility) {
        overtimeDamage = dmg;
        overtimeRounds = rounds;
        incapacity = immobility;
    }

    final String getCoordinates() {
        return x + " " + y;
    }

    /**
     * Used by double dispatch. Applied by the player that gets the damage.
     * @param attacker - the player that attacks;
     * @return - computed damage;
     */
    protected abstract int acceptAttack(Hero attacker);
}
