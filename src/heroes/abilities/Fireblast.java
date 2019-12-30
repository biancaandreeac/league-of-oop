package heroes.abilities;

import common.Constants;
import heroes.Hero;
import heroes.Rogue;
import heroes.Knight;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Fireblast extends Ability {

    Fireblast(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
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
    public final float useAbility(final Hero pyromancer, final Rogue opponent) {
        return applyAbility(pyromancer, RaceModifiers.ROGUE + pyromancer.angelModifier);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Knight opponent) {
        return applyAbility(pyromancer, RaceModifiers.KNIGHT + pyromancer.angelModifier);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Pyromancer opponent) {
        return applyAbility(pyromancer, RaceModifiers.PYROMANCER + pyromancer.angelModifier);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Wizard opponent) {
        return applyAbility(pyromancer, RaceModifiers.WIZARD + pyromancer.angelModifier);
    }

    @Override
    public final float applyAbility(final Hero pyromancer, final float raceAmplifier) {
        float damage = baseDamage(pyromancer);
        damage *= raceAmplifier - Constants.APPROXIMATION_ERR;
        return Math.round(damage);
    }
}
