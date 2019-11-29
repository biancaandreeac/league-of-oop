package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;

import map.CellType;

public class Slam extends Ability {
    private float damage;

    public Slam(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
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
    public final int useAbility(final Hero knight, final Rogue opponent) {
        applyAbility(knight, RaceModifiers.ROGUE);
        opponent.setDamageOverTime(0, 0, 1);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero knight, final Knight opponent) {
        applyAbility(knight, RaceModifiers.KNIGHT);
        opponent.setDamageOverTime(0, 0, 1);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero knight, final Pyromancer opponent) {
        applyAbility(knight, RaceModifiers.PYROMANCER);
        opponent.setDamageOverTime(0, 0, 1);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero knight, final Wizard opponent) {
        applyAbility(knight, RaceModifiers.WIZARD);
        opponent.setDamageOverTime(0, 0, 1);
        return (int) damage;
    }

    @Override
    public final int applyAbility(final Hero knight, final float raceAmplifier) {
        damage = baseDamage(knight);
        damage *= raceAmplifier;
        damage = Math.round(damage);
        return (int) damage;
    }
}
