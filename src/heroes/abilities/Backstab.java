package heroes.abilities;

import common.Constants;
import heroes.Hero;
import heroes.Rogue;
import heroes.Knight;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Backstab extends Ability {
    private float damage;

    Backstab(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand = CellType.Woods;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 1.2f;
        static final float KNIGHT = 0.9f;
        static final float PYROMANCER = 1.25f;
        static final float WIZARD = 1.25f;
    }

    /**
     * Computes the base damage applied by rogue players.
     * @param rogue - the player that attacks.
     * @return computed base damage
     */
    @Override
    final float baseDamage(final Hero rogue) {
        damage = super.baseDamage(rogue);
        /* The damage can be amplified by 1.5 one time in every 3 rounds if the fight is *
         * being held in the woods                                                       */
        if (rogue.getLocationType() == CellType.Woods && ((Rogue) rogue).getHits() >= 0) {
            final float amplifier = 1.5f;
            damage *= amplifier;
        }
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero rogue, final Rogue opponent) {
        return applyAbility(rogue, RaceModifiers.ROGUE + rogue.angelModifier);
    }

    @Override
    public final float useAbility(final Hero rogue, final Knight opponent) {
        return applyAbility(rogue, RaceModifiers.KNIGHT + rogue.angelModifier);
    }

    @Override
    public final float useAbility(final Hero rogue, final Pyromancer opponent) {
        return applyAbility(rogue, RaceModifiers.PYROMANCER + rogue.angelModifier);
    }

    @Override
    public final float useAbility(final Hero rogue, final Wizard opponent) {
        return applyAbility(rogue, RaceModifiers.WIZARD + rogue.angelModifier);
    }

    @Override
    public final float applyAbility(final Hero rogue, final float raceAmplifier) {
        damage = baseDamage(rogue);
        ((Rogue) rogue).incHits();

        /* If the damage has been amplified, this amplifier can't be used for the remaining *
         * rounds from the 3 round set                                                      */
        if (rogue.getLocationType() == CellType.Woods && ((Rogue) rogue).getHits() >= 0) {
            ((Rogue) rogue).resetBackstabHits();
        }

        damage *= raceAmplifier - Constants.APPROXIMATION_ERR;
        return Math.round(damage);
    }
}
