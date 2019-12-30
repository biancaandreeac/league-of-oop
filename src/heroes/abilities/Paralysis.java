package heroes.abilities;

import heroes.Hero;
import heroes.Rogue;
import heroes.Knight;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Paralysis extends Ability {
    private float damage;

    public Paralysis(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand = CellType.Woods;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 0.9f;
        static final float KNIGHT = 0.8f;
        static final float PYROMANCER = 1.2f;
        static final float WIZARD = 1.25f;
    }

    @Override
    public final float useAbility(final Hero rogue, final Rogue opponent) {
        applyAbility(rogue, RaceModifiers.ROGUE + rogue.angelModifier);
        damageOverTime(opponent);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero rogue, final Knight opponent) {
        applyAbility(rogue, RaceModifiers.KNIGHT + rogue.angelModifier);
        damageOverTime(opponent);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero rogue, final Pyromancer opponent) {
        applyAbility(rogue, RaceModifiers.PYROMANCER + rogue.angelModifier);
        damageOverTime(opponent);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero rogue, final Wizard opponent) {
        applyAbility(rogue, RaceModifiers.WIZARD + rogue.angelModifier);
        damageOverTime(opponent);
        return Math.round(damage);
    }

    @Override
    public final float applyAbility(final Hero rogue, final float raceAmplifier) {
        damage = baseDamage(rogue);
        damage *= raceAmplifier - 0.000001f;
        return Math.round(damage);
    }

    private void damageOverTime(final Hero opponent) {
        if (opponent.getLocationType() == CellType.Woods) {
            final int roundsInWoods = 6;
            opponent.setDamageOverTime(Math.round(damage), roundsInWoods, roundsInWoods);
        } else {
            final int roundsNotInWoods = 3;
            opponent.setDamageOverTime(Math.round(damage), roundsNotInWoods, roundsNotInWoods);
        }
    }
}
