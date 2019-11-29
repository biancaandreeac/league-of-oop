package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Execute extends Ability {
    private final float percent = 0.2f;
    private final float percentAddPerLevel = 0.01f;
    private final float maxPercent = 0.4f;

    public Execute(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand = CellType.Land;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 1.15f;
        static final float KNIGHT = 1f;
        static final float PYROMANCER = 1.1f;
        static final float WIZARD = 0.8f;
    }

    @Override
    public final int useAbility(final Hero knight, final Rogue opponent) {
        if (opponent.getHp() <= computeLimit(opponent, knight.getLvl())) {
            return opponent.getHp();
        }
        return applyAbility(knight, RaceModifiers.ROGUE);
    }

    @Override
    public final int useAbility(final Hero knight, final Knight opponent) {
        if (opponent.getHp() <= computeLimit(opponent, knight.getLvl())) {
            return opponent.getHp();
        }
        return applyAbility(knight, RaceModifiers.KNIGHT);
    }

    @Override
    public final int useAbility(final Hero knight, final Pyromancer opponent) {
        if (opponent.getHp() <= computeLimit(opponent, knight.getLvl())) {
            return opponent.getHp();
        }
        return applyAbility(knight, RaceModifiers.PYROMANCER);
    }

    @Override
    public final int useAbility(final Hero knight, final Wizard opponent) {
        if (opponent.getHp() <= computeLimit(opponent, knight.getLvl())) {
            return opponent.getHp();
        }
        return applyAbility(knight, RaceModifiers.WIZARD);
    }


    @Override
    public final int applyAbility(final Hero knight, final float raceAmplifier) {
        float damage = baseDamage(knight);
        damage *= raceAmplifier;
        damage = Math.round(damage);
        return (int) damage;
    }

    /**
     * Computes the life limit that determines whether or not the opponent is executed.
     * @param opponent - the player attacked;
     * @param attackerLvl - level of the attacker;
     * @return - the limit
     */
    private int computeLimit(final Hero opponent, final int attackerLvl) {
        int limit = opponent.getHpMax() + opponent.getLvl() * opponent.getHPlvl();
        limit *= Math.min(percent + attackerLvl * percentAddPerLevel, maxPercent);
        return Math.round(limit);
    }
}