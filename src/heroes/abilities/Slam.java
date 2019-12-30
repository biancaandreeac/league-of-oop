package heroes.abilities;

import heroes.Hero;
import heroes.Rogue;
import heroes.Knight;
import heroes.Wizard;
import heroes.Pyromancer;

import map.CellType;

public class Slam extends Ability {
    private float damage;

    Slam(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand = CellType.Land;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 0.8f;
        static final float KNIGHT = 1.2f;
        static final float PYROMANCER = 0.9f;
        static final float WIZARD = 1.05f;
    }

    @Override
    public final float useAbility(final Hero knight, final Rogue opponent) {
        applyAbility(knight, RaceModifiers.ROGUE + knight.angelModifier);
        opponent.setDamageOverTime(0, 0, 1);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero knight, final Knight opponent) {
        applyAbility(knight, RaceModifiers.KNIGHT + knight.angelModifier);
        opponent.setDamageOverTime(0, 0, 1);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero knight, final Pyromancer opponent) {
        applyAbility(knight, RaceModifiers.PYROMANCER + knight.angelModifier);
        opponent.setDamageOverTime(0, 0, 1);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero knight, final Wizard opponent) {
        applyAbility(knight, RaceModifiers.WIZARD + knight.angelModifier);
        opponent.setDamageOverTime(0, 0, 1);
        return Math.round(damage);
    }

    @Override
    public final float applyAbility(final Hero knight, final float raceAmplifier) {
        damage = baseDamage(knight);
        damage *= raceAmplifier;
        return Math.round(damage);
    }
}
