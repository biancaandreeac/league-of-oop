package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Fireblast extends Ability {
    private float damage;

    public Fireblast(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand =  CellType.Volcanic;
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
    public final int useAbility(final Hero pyromancer, final Rogue opponent) {
        return applyAbility(pyromancer, RaceModifiers.ROGUE);
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Knight opponent) {
        return applyAbility(pyromancer, RaceModifiers.KNIGHT);
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Pyromancer opponent) {
        return applyAbility(pyromancer, RaceModifiers.PYROMANCER);
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Wizard opponent) {
        return applyAbility(pyromancer, RaceModifiers.WIZARD);
    }

    @Override
    public final int applyAbility(final Hero pyromancer, final float raceAmplifier) {
        damage = baseDamage(pyromancer);
        damage *= raceAmplifier;
        damage = Math.round(damage);
        return (int) damage;
    }
}
