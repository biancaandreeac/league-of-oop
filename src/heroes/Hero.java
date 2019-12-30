package heroes;

import common.Constants;
import common.Observable;
import common.Observer;
import common.Visitable;
import heroes.abilities.AbilityType;
import heroes.strategies.HeroStrategy;
import map.Cell;
import map.CellType;
import map.Map;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Hero implements Visitable, Observable {
    private int id;
    public float angelModifier = 0f;

    private int hp, hpLvl;
    private final int hpMax;
    private int xp = 0;
    private int lvl = 0;
    private int incapacity = 0;
    private int x, y; // coordinates

    private int overtimeDamage;
    private int overtimeRounds = 0;

    private HeroType type;
    private Cell location;
    protected ArrayList<AbilityType> abilities;
    HeroStrategy strategy;
    private Observer heroObserver;

    Hero(final int hp, final int hpLvl, final HeroType type, final ArrayList<AbilityType> ab) {
        this.hp = hp;
        hpMax = hp;
        this.hpLvl = hpLvl;
        this.type = type;
        abilities = ab;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public HeroType getType() {
        return type;
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
        return hpMax + lvl * hpLvl;
    }

    final String getCoordinates() {
        return x + " " + y;
    }

    public final CellType getLocationType() {
        return location.getType();
    }

    public final ArrayList<AbilityType> getAbilities() {
        return abilities;
    }

    public final boolean canMove() {
        if (incapacity == 0) {
            chooseStrategy();
            return true;
        }
        --incapacity;
        return false;
    }

    public final boolean isDead() {
        if (hp <= 0) {
            hp = 0;
            return true;
        }
        return false;
    }

    public void checkLvl() throws IOException {
        if (isDead()) {
            return;
        }
        final int baseXP = 250;
        final int lvlXP = 50;
        int res = baseXP + lvl * lvlXP;
        while (res <= xp) {
            lvl++;
            notifyObserver();
            res += lvlXP;
            hp = hpMax + lvl * hpLvl;
        }
    }

    public void subHP(final int delta) {
        if (hp - delta > getHpMax()) {
            hp = getHpMax();
        } else {
            hp -= delta;
        }
    }

    public void addXP(final int delta) {
        xp += delta;
    }

    public final void initLocation(final int newX, final int newY) {
        x = newX;
        y = newY;
        location = Map.getCellAt(x, y);
        location.visit(this);
    }

    public final void move(final int deltaX, final int deltaY) {
        x += deltaX;
        y += deltaY;
        location.leave(this);
        if (!(x < 0 || y < 0)) {
            location = Map.getCellAt(x, y);
            location.visit(this);
        }
    }

    public final void fight() throws IOException {
        Hero opponent = location.getOpponent(this);
        if (opponent != null && !opponent.isDead()) {
            int dmgOpponent, dmgThis, computedXp;

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

            /* Add xp if someone is defeated */
            if (opponent.getHp() <= 0 && getHp() > 0) {
                computedXp = Constants.XP_MAX;
                computedXp -= ((getLvl() - opponent.getLvl()) * Constants.XP_MULTIPLIER);
                addXP(Math.max(0, computedXp));
            } else if (getHp() <= 0 && opponent.getHp() > 0) {
                computedXp = Constants.XP_MAX;
                computedXp -= ((opponent.getLvl() - getLvl()) * Constants.XP_MULTIPLIER);
                opponent.addXP(Math.max(0, computedXp));
            }

            notifyObserver(opponent);
            checkLvl();
            opponent.checkLvl();
        }
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

    /**
     * Used by double dispatch. Applied by the player that gets the damage.
     * @param attacker - the player that attacks;
     * @return - computed damage;
     */
    protected abstract int acceptAttack(Hero attacker);

    public abstract void chooseStrategy();

    /**
     * Used by LevelUpAngel.
     */
    public void lvlUp() throws IOException {
        final int baseXP = 250;
        final int lvlXP = 50;
        xp = baseXP + lvl * lvlXP;
        lvl++;
        hp = hpMax + lvl * hpLvl;
        notifyObserver();
    }

    /**
     * Used when he gets to a new level.
     */
    @Override
    public void notifyObserver() throws IOException {
        heroObserver.update(this);
    }

    /**
     * Used when 2 players fight to check if there is anyone defeated.
     * @param hero - the opponent.
     */
    @Override
    public void notifyObserver(Object hero) throws IOException {
        heroObserver.update(hero, this);
    }

    @Override
    public void register(Observer observer) {
        heroObserver = observer;
    }
}
